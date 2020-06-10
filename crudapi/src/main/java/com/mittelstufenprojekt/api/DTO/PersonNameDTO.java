package com.mittelstufenprojekt.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mittelstufenprojekt.api.domain.Employee;
import com.mittelstufenprojekt.api.domain.Customer;

public class PersonNameDTO {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;

    public PersonNameDTO(Employee employee) {
        this.id = employee.getId();
        this.firstname = employee.getName();
        this.lastname = employee.getLastname();
    }

    public PersonNameDTO(Customer customer) {
        this.id = customer.getId();
        this.firstname = customer.getName();
        this.lastname = customer.getLastname();
    }

    public PersonNameDTO() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
