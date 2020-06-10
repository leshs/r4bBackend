package com.mittelstufenprojekt.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mittelstufenprojekt.api.domain.Contract;

import java.time.LocalDate;

public class ContractDTO {
    @JsonProperty
    private LocalDate startDate;
    @JsonProperty
    private LocalDate endDate;
    @JsonProperty
    private CustomerDTO customer;
    @JsonProperty
    private TarifDTO tarifDTO;
    @JsonProperty
    private Float price;

    public ContractDTO(){}

    public ContractDTO(Contract contract) {
        this.startDate = contract.getStartDate();
        this.endDate = contract.getEndDate();
        this.customer = new CustomerDTO(contract.getCustomer());
        this.tarifDTO = new TarifDTO(contract.getTarif());
    }

    public Contract parseDTO() {
        Contract contract = new Contract();
        contract.setCustomer(customer.parseDTO());
        contract.setEndDate(endDate);
        contract.setStartDate(startDate);
        contract.setTarif(tarifDTO.parseDTO());
        return contract;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public TarifDTO getTarifDTO() {
        return tarifDTO;
    }

    public void setTarifDTO(TarifDTO tarifDTO) {
        this.tarifDTO = tarifDTO;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
