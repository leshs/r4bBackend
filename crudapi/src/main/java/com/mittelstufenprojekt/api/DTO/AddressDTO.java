package com.mittelstufenprojekt.api.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mittelstufenprojekt.api.domain.Address;

public class AddressDTO {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String street;
    @JsonProperty
    private int zipcode;
    @JsonProperty
    private String city;
    @JsonProperty
    private String number;

    public AddressDTO() {}


    public AddressDTO(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.zipcode = address.getZipcode();
        this.city = address.getCity();
        this.number = address.getNumber();
    }

    @JsonIgnore
    public Address parseDTO() {
        Address address = new Address();
        address.setCity(city);
        address.setZipcode(zipcode);
        address.setNumber(number);
        address.setStreet(street);
        if(id != null) {
            address.setId(id);
        }
        return address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
