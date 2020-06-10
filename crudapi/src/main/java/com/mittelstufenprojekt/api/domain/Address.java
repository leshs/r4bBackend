package com.mittelstufenprojekt.api.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Address")
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "Street")
    private String street;
    @Column(name = "ZipCode")
    private int zipcode;
    @Column(name = "City")
    private String city;
    @Column(name = "Number")
    private String number;
    @OneToMany(mappedBy = "address")
    private List<Person> personList;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", zipcode=" + zipcode +
                ", city='" + city + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
