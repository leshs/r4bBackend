package com.mittelstufenprojekt.api.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee extends Person {
    @Column
    private Float salary;

    @OneToMany(mappedBy = "employee")
    private List<Lesson> lessonList;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Employee_Subject",
            joinColumns = {@JoinColumn(name = "Employee_ID")},
            inverseJoinColumns = {@JoinColumn(name = "Subject_ID")}
    )
    List<Subject> subjects = new ArrayList<>();

    @Column(name = "isAdmin")
    private boolean isAdmin;

    public Employee() {
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "TestModell{" +
                "salary=" + salary +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
