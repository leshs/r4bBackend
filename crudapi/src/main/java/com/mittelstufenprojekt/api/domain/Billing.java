package com.mittelstufenprojekt.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mittelstufenprojekt.api.DTO.AccountDTO;
import com.mittelstufenprojekt.api.DTO.AddressDTO;
import com.mittelstufenprojekt.api.DTO.ContractDTO;
import com.mittelstufenprojekt.api.DTO.PersonNameDTO;

import java.time.LocalDate;
import java.util.List;

public class Billing {
    @JsonProperty
    private PersonNameDTO customerName;
    @JsonProperty
    private float price;
    @JsonProperty
    private LocalDate date;
    @JsonProperty
    private List<ContractDTO> contractDTOS;
    @JsonProperty
    private AddressDTO addressDTO;
    @JsonProperty
    private AccountDTO accountDTO;

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public AccountDTO getAccountDTO() {
        return accountDTO;
    }

    public void setAccountDTO(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }

    public PersonNameDTO getCustomerName() {
        return customerName;
    }

    public void setCustomerName(PersonNameDTO customerName) {
        this.customerName = customerName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ContractDTO> getContractDTOS() {
        return contractDTOS;
    }

    public void setContractDTOS(List<ContractDTO> contractDTOS) {
        this.contractDTOS = contractDTOS;
    }
}
