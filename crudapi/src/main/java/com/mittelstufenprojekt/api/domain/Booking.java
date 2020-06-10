package com.mittelstufenprojekt.api.domain;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Booking")
@org.hibernate.annotations.NamedQuery(name = "Find_Booking_By_Date_Span",
        query = "from Booking b where Date = :date ")

public class Booking {
    //JPA composite key primarykey.class oder so. Composite Klasse, die beide Schlüssel kombiniert.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "StartTime")
    private LocalTime startTime;
    @Column(name = "EndTime")
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "Room_ID", nullable = false)
    private Room room;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Lesson_ID", referencedColumnName = "ID")
    private Lesson lesson;

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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

}
