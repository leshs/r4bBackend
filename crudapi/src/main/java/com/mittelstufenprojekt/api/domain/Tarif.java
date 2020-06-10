package com.mittelstufenprojekt.api.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tarif")
public class Tarif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Duration")
    private int duration;
    @Column(name = "Name")
    private String name;
    @Column(name = "CancellationPeriod")
    private int cancellationPeriod;
    @Column(name = "LessonPerWeek")
    private int lessonPerWeek;
    @Column(name = "LessonLength")
    private int lessonLength;
    @Column(name = "Price")
    private Float price;
    @ManyToOne
    @JoinColumn(name = "Subject_ID", nullable = false)
    private Subject subject;

    @OneToMany(mappedBy = "tarif")
    private List<Contract> contractList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCancellationPeriod() {
        return cancellationPeriod;
    }

    public void setCancellationPeriod(int cancellationPeriod) {
        this.cancellationPeriod = cancellationPeriod;
    }

    public int getLessonPerWeek() {
        return lessonPerWeek;
    }

    public void setLessonPerWeek(int lessonPerWeek) {
        this.lessonPerWeek = lessonPerWeek;
    }

    public int getLessonLength() {
        return lessonLength;
    }

    public void setLessonLength(int lessonLength) {
        this.lessonLength = lessonLength;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Tarif{" +
                "id=" + id +
                ", duration=" + duration +
                ", name='" + name + '\'' +
                ", cancellationPeriod=" + cancellationPeriod +
                ", lessonPerWeek=" + lessonPerWeek +
                ", lessonLength=" + lessonLength +
                ", price=" + price +
                ", subject=" + subject +
                ", contractList=" + contractList +
                '}';
    }
}
