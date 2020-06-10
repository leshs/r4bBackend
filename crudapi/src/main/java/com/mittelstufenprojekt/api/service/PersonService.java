package com.mittelstufenprojekt.api.service;

import com.mittelstufenprojekt.api.domain.Billing;
import com.mittelstufenprojekt.api.domain.Customer;
import com.mittelstufenprojekt.api.domain.Employee;

import java.util.List;

public interface PersonService {
        void addEmployee(Employee employee);
        void addCustomer(Customer customer);

        Employee getEmployeeById(Long id);
        Customer getCustomerById(Long id);

        void deleteEmployee(Long id);
        void deleteCustomer(Long id);

        List<Employee> getAllEmployees();
        List<Customer> getAllCustomers();

        Billing getBilling(Long customerId);


}
