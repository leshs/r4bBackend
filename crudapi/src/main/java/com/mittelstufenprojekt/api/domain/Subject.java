package com.mittelstufenprojekt.api.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Subject")
@org.hibernate.annotations.NamedQuery(name = "Subject_Find_All",
        query = "from Subject s")
public class Subject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Info")
    private String info;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.EAGER)
    private Set<Employee> employees = new HashSet<>();

    @ManyToMany(mappedBy = "subjects")
    private Set<Room> rooms = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private List<Tarif> tarifList;

    @OneToMany(mappedBy = "subject")
    private List<Lesson> lessonList;

    public Subject() {
    }

    public void addTarif(Tarif tarif) {
        tarifList.add(tarif);
    }

    public Subject(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", employees=" + employees +
                ", rooms=" + rooms +
                ", tarifList=" + tarifList +
                ", lessonList=" + lessonList +
                '}';
    }
}
