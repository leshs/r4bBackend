package com.mittelstufenprojekt.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mittelstufenprojekt.api.domain.Subject;

public class SubjectDTO {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String info;

    public SubjectDTO() {
    }

    public SubjectDTO (Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
        this.info = subject.getInfo();
    }

    public Subject parseDTO() {
        Subject subject = new Subject();
        subject.setId(id);
        subject.setInfo(info);
        subject.setName(name);
        return subject;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
