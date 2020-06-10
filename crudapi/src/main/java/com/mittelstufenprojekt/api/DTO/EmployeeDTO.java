package com.mittelstufenprojekt.api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mittelstufenprojekt.api.domain.Employee;
import com.mittelstufenprojekt.api.domain.Subject;

import java.util.ArrayList;
import java.util.List;


public class EmployeeDTO extends PersonDTO {
    @JsonProperty
    private float salary;
    @JsonProperty
    private boolean admin;
    @JsonProperty
    private List<SubjectDTO> subjectDTOS;

    public EmployeeDTO() {
    }


    public EmployeeDTO(Employee employee) {
        setFirstname(employee.getName());
        setLastname(employee.getLastname());
        setBirthdate(employee.getBirthdate());
        setBirthplace(employee.getBirthplace());
        setEmail(employee.getEmail());
        setPassword(employee.getPassword());
        setPhone(employee.getPhone());
        setAccountModell(new AccountDTO(employee.getAccount()));
        setAddressDTO(new AddressDTO(employee.getAddress()));
        subjectDTOS = new ArrayList<>();

        List<Subject> subjects = employee.getSubjects();
        for(Subject subject : subjects) {
            subjectDTOS.add(new SubjectDTO(subject));
        }
        salary = employee.getSalary();
        admin = employee.isAdmin();
    }


    @JsonIgnore
    public Employee parseDTO() {
        Employee employee = new Employee();
        employee.setName(getFirstname());
        employee.setLastname(getLastname());
        employee.setBirthdate(getBirthdate());
        employee.setBirthplace(getBirthplace());
        employee.setEmail(getEmail());
        employee.setPassword(getPassword());
        employee.setPhone(getPhone());
        if(getAddressDTO() != null) {
            employee.setAddress(getAddressDTO().parseDTO());
        }
        if(getAccountModell() != null) {
            employee.setAccount(getAccountModell().parseDTO());
        }

        employee.setAdmin(admin);
        employee.setSalary(salary);
        return employee;
    }
    public float getSalary() {
        return salary;
    }


    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
