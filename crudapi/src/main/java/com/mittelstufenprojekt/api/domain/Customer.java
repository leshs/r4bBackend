package com.mittelstufenprojekt.api.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Customer")

public class Customer extends Person {
    @OneToMany(mappedBy = "customer")
    private List<Contract> contractList;

    @ManyToMany(mappedBy = "customers")
    private List<Lesson> lessons;

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "contractList=" + contractList +
                ", lessons=" + lessons +
                '}';
    }
}
