package com.mittelstufenprojekt.api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mittelstufenprojekt.api.domain.Contract;
import com.mittelstufenprojekt.api.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO extends PersonDTO {
    @JsonProperty
    private List<ContractDTO> contracts;


    @JsonIgnore
    public Customer parseDTO() {
        Customer customer = new Customer();
        customer.setName(getFirstname());
        customer.setLastname(getLastname());
        customer.setBirthdate(getBirthdate());
        customer.setBirthplace(getBirthplace());
        customer.setEmail(getEmail());
        customer.setPassword(getPassword());
        customer.setPhone(getPhone());
        if (getAddressDTO() != null) {
            customer.setAddress(getAddressDTO().parseDTO());
        }
        if (getAccountModell() != null) {
            customer.setAccount(getAccountModell().parseDTO());
        }
        if (getId() != null) {
            customer.setId(getId());
        }
        return customer;
    }
    public CustomerDTO() {
    }

    public CustomerDTO(Customer customer) {
        setFirstname(customer.getName());
        setLastname(customer.getLastname());
        setBirthdate(customer.getBirthdate());
        setBirthplace(customer.getBirthplace());
        setEmail(customer.getEmail());
        setPassword(customer.getPassword());
        setPhone(customer.getPhone());
        setAccountModell(new AccountDTO(customer.getAccount()));
        setAddressDTO(new AddressDTO(customer.getAddress()));
        List<Contract> contractList = customer.getContractList();
        contracts = new ArrayList<>();
        for(Contract contract:contractList) {
            contracts.add(new ContractDTO(contract));
        }
    }

    public List<ContractDTO> getContracts() {
        return contracts;
    }

    public void setContracts(List<ContractDTO> contracts) {
        this.contracts = contracts;
    }
}
