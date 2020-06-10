package com.mittelstufenprojekt.api.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "IBAN")
    private String iban;
    @Column(name = "BIC")
    private String bic;
    @Column(name = "firstname")
    String firstname;
    @Column(name = "lastname")
    String lastname;
    @OneToMany(mappedBy = "account")
    private List<Person> personList;

    public Account(String iban, String bic) {
        this.iban = iban;
        this.bic = bic;
    }



    public Account() {
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

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                '}';
    }
}
