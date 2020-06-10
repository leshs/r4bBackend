package com.mittelstufenprojekt.api.dao;


import com.mittelstufenprojekt.api.domain.Employee;
import com.mittelstufenprojekt.api.domain.Billing;
import com.mittelstufenprojekt.api.domain.Customer;

import java.util.List;

public interface PersonDAO {
    void addEmployee(Employee employee);

    void deleteEmployee(Long id);

    void updateEmployee(Employee employee, Long id);


    void addCustomer(Customer customer);

    void deleteCustomer(Long id);

    void updateCustomer(Customer customer, Long id);

    Employee getEmployee(Long id);

    Customer getCustomer(Long id);

    List<Employee> getAllEmployees();

    List<Customer> getAllCustomers();

    Billing getBilling(Long customerId);
}
