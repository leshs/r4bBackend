package com.mittelstufenprojekt.api.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.JOINED)

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Lastname")
    private String lastname;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "Birthplace")
    private String birthplace;
    @Column(name = "Birthdate")
    private LocalDate birthdate;
    @Column(name = "Passwort")
    private String password;
    @Column(name = "Phone")
    private int phone;


    @ManyToOne
    @JoinColumn(name = "Address_ID", nullable = false)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "Account_ID", nullable = false)
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", birthdate=" + birthdate +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", address=" + address +
                ", account=" + account +
                '}';
    }
}
