package com.mittelstufenprojekt.api.dao;

import com.mittelstufenprojekt.api.DTO.*;
import com.mittelstufenprojekt.api.domain.Contract;
import com.mittelstufenprojekt.api.domain.Employee;
import com.mittelstufenprojekt.api.domain.Billing;
import com.mittelstufenprojekt.api.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public void addEmployee(Employee employee) {
        entityManager.persist(employee);
    }


    @Override
    public void deleteEmployee(Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

    @Override
    public void updateEmployee(Employee employee, Long id) {
        Employee employeeOld = entityManager.find(Employee.class, id);
        entityManager.merge(employee);
    }

    @Override
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        entityManager.remove(entityManager.find(Customer.class, id));
    }

    @Override
    public void updateCustomer(Customer customer, Long id) {
        //TODO
    }

    @Override
    public Employee getEmployee(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Customer getCustomer(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> select_a_from_employee_a = entityManager.createQuery("select a FROM Employee a", Employee.class);
        return select_a_from_employee_a.getResultList();
    }

    @Override
    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> selectCustomerQuery = entityManager.createQuery("select a FROM Customer a", Customer.class);
        return selectCustomerQuery.getResultList();
    }

    //returns the bill for the current month, so customers can print it
    @Override
    public Billing getBilling(Long customerId) {
        TypedQuery<Contract> contractQuery = entityManager.createQuery("select a FROM Contract a where a.customer.id = :customerID", Contract.class);
        contractQuery.setParameter("customerID", customerId);
        List<Contract> resultList = contractQuery.getResultList();
        LocalDate now = LocalDate.now();
        Customer customer = entityManager.find(Customer.class, customerId);
        CustomerDTO customerDTO = new CustomerDTO(customer);
        Billing billing = new Billing();
        billing.setCustomerName(new PersonNameDTO(customer));
        billing.setDate(now);
        List<ContractDTO> contractDTOS = new ArrayList<>();
        for (Contract contract : resultList) {
            if (contract.getEndDate().isBefore(now)) {
                ContractDTO contractDTO = new ContractDTO(contract);
                Float price = contract.getTarif().getPrice();
                contractDTO.setPrice(price);
                billing.setPrice(billing.getPrice() + price);
                contractDTOS.add(contractDTO);
            }
        }
        billing.setContractDTOS(contractDTOS);
        billing.setAccountDTO(new AccountDTO(customer.getAccount()));
        billing.setAddressDTO(new AddressDTO(customer.getAddress()));
        return billing;
    }
}
