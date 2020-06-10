package com.mittelstufenprojekt.api.service;

import com.mittelstufenprojekt.api.dao.PersonDAO;
import com.mittelstufenprojekt.api.domain.Billing;
import com.mittelstufenprojekt.api.domain.Customer;
import com.mittelstufenprojekt.api.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDAO personDAO;

    @Transactional
    @Override
    public void addEmployee(Employee employee) {
        personDAO.addEmployee(employee);
    }

    @Transactional
    @Override
    public void addCustomer(Customer customer) {
        personDAO.addCustomer(customer);
    }

    @Transactional
    @Override
    public Employee getEmployeeById(Long id) {
        return personDAO.getEmployee(id);
    }

    @Transactional
    @Override
    public Customer getCustomerById(Long id) {
        return null;
    }

    @Transactional
    @Override
    public void deleteEmployee(Long id) {
        //TODO
    }

    @Transactional
    @Override
    public void deleteCustomer(Long id) {
        //TODO
    }

    @Override
    public List<Employee> getAllEmployees() {
        return personDAO.getAllEmployees();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return personDAO.getAllCustomers();
    }

    @Override
    public Billing getBilling(Long customerId) {
        return personDAO.getBilling(customerId);
    }
}
