package com.mittelstufenprojekt.api.controller;

import com.mittelstufenprojekt.api.domain.Contract;
import com.mittelstufenprojekt.api.domain.Employee;
import com.mittelstufenprojekt.api.service.PersonService;
import com.mittelstufenprojekt.api.DTO.ContractDTO;
import com.mittelstufenprojekt.api.DTO.CustomerDTO;
import com.mittelstufenprojekt.api.DTO.EmployeeDTO;
import com.mittelstufenprojekt.api.domain.Billing;
import com.mittelstufenprojekt.api.domain.Customer;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;



    @Operation(summary = "add employee",
            description = "add employee with all attributes",
            tags = "person-controller")
    @PostMapping("/employee/add")
    public void addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        personService.addEmployee(employeeDTO.parseDTO());
    }




    @Operation(summary = "get all employee",
            description = "gets all employees with all attributes",
            tags = "person-controller")
    @GetMapping("/employee/all")
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = personService.getAllEmployees();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for(Employee employee : employees) {
            employeeDTOS.add(new EmployeeDTO(employee));
        }
        return employeeDTOS;
    }



    @Operation(summary = "get employee",
            description = "gets a signle employee by id",
            tags = "person-controller")
    @GetMapping("/employee/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        Employee employeeById = personService.getEmployeeById(id);
        return new EmployeeDTO(employeeById);
    }



    @Operation(summary = "add customer",
            description = "add customer with all attributes",
            tags = "person-controller")
    @PostMapping("/customer/add")
    public void addCustomer(@RequestBody CustomerDTO customerDTO) {
        personService.addCustomer(customerDTO.parseDTO());
    }



    @Operation(summary = "get customer",
            description = "gets a signle customer by id",
            tags = "person-controller")
    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        Customer customerById = personService.getCustomerById(id);
        return new CustomerDTO(customerById);
    }


    @Operation(summary = "get all customers",
            description = "gets all customers with all attributes",
            tags = "person-controller")
    @GetMapping("/customer/all")
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = personService.getAllCustomers();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for(Customer customer : customers) {
            customerDTOS.add(new CustomerDTO(customer));
        }
        return customerDTOS;
    }


    @Operation(summary = "add contract",
            description = "add a contract for a specified customer",
            tags = "person-controller")
    @PostMapping
    public void addContract(@RequestBody ContractDTO contractDTO) {
        Contract contract = contractDTO.parseDTO();
        //TODO Contractservice implementieren
    }


    @Operation(summary = "get billing",
            description = "gets the bill for a customer for the current month",
            tags = "person-controller")
    @GetMapping("/customer/bill/{id}")
    public Billing getBill(@PathVariable Long id) {
        return personService.getBilling(id);
    }
}
