package com.mittelstufenprojekt.api.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Room")
@NamedQueries({

        @NamedQuery(name = "Room_Find_All",
                query = "from Room r"),
        @NamedQuery(name = "Room_Find_Free_By_Time",
                query = "from Booking b where Date = :date " +
                        "and Start_Time not between :startTime and :endTime " +
                        "AND End_Time not between :startTime and :endTime")

})

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Info")
    private String info;

    @Column(name = "Capacity")
    private int capacity;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Subject_Room",
            joinColumns = {@JoinColumn(name = "Room_ID")},
            inverseJoinColumns = {@JoinColumn(name = "Subject_ID")}
    )
    private List<Subject> subjects = new ArrayList<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Booking> bookingList;


    public Room(String info) {
        this.info = info;
    }

    public Room() {
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }
/*
    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", subjects=" + subjects +
                ", bookingList=" + bookingList +
                '}';
    }

 */
}
