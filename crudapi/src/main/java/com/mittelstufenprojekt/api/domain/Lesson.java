package com.mittelstufenprojekt.api.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Lesson")

@NamedQueries({

        @NamedQuery(name = "Lesson_By_Date_Span",
                query = "select B.lesson From Booking B where B.date between :startDate and :endDate"),
        @NamedQuery(name = "Lesson_By_Employee",
                query = "select B.lesson From Booking B where B.date between :startDate and :endDate " +
                        "AND B.lesson.employee.id = :employeeID"),
       // @org.hibernate.annotations.NamedQuery(name = "Lesson_By_Customer",
         //       query = "select B.lesson From Booking B where B.date between :startDate and :endDate " +
           //             "AND B.lesson.customers.customer.id = :customerID"),
        @NamedQuery(name = "Lesson_By_Customer_Date",
                query = "select L from Lesson L join L.customers c where c.id= :customerID and L.date between :startDate and :endDate"),
})

public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Topic")
    private String topic;
    @Column(name = "isCanceled")
    private boolean isCancelled;
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "StartTime")
    private LocalTime startTime;
    @Column(name = "EndTime")
    private LocalTime endTime;
    @ManyToOne
    @JoinColumn(name = "Employee_ID", nullable = false)
    private Employee employee;

    @OneToOne(mappedBy = "lesson")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "Subject_ID", nullable = false)
    private Subject subject;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Customer_Lesson",
            joinColumns = {@JoinColumn(name = "Lesson_ID")},
            inverseJoinColumns = {@JoinColumn(name = "Customer_ID")}
    )
    List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

}
