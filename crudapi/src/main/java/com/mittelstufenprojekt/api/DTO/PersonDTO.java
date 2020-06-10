package com.mittelstufenprojekt.api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class PersonDTO {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private LocalDate birthdate;
    @JsonProperty
    private String email;
    @JsonIgnore
    private String password;
    @JsonProperty
    private String birthplace;
    @JsonProperty
    private int phone;
    @JsonProperty(value = "address")
    private AddressDTO addressDTO;
    @JsonProperty(value = "account")
    private AccountDTO accountModell;

    public PersonDTO(){}


    public LocalDate parseDate(String date) {
        if(date != null) {
            return LocalDate.parse("2020-03-15");
        } else {
            return null;
        }
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public AccountDTO getAccountModell() {
        return accountModell;
    }

    public void setAccountModell(AccountDTO accountModell) {
        this.accountModell = accountModell;
    }
}
