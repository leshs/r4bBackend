package com.mittelstufenprojekt.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mittelstufenprojekt.api.domain.Room;
import com.mittelstufenprojekt.api.domain.Subject;

import java.util.ArrayList;
import java.util.List;

public class RoomDTO {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String info;

    @JsonProperty
    private int capacity;

    @JsonProperty(value = "subjects")
    private List<SubjectDTO> subjectList;

    public RoomDTO(Room room) {
        this.id = room.getId();
        this.info = room.getInfo();
        this.capacity = room.getCapacity();
        subjectList = new ArrayList<>();
        List<Subject> subjects = room.getSubjects();
        for(Subject subject: subjects) {
            subjectList.add(new SubjectDTO(subject));
        }
    }

    public RoomDTO() {

    }

    public Room parseDTO() {
        Room room = new Room();
        room.setInfo(info);
        room.setId(id);
        room.setCapacity(capacity);
        List<Subject> subjects = new ArrayList<>();
        for(SubjectDTO subjectDTO : subjectList) {
            subjects.add(subjectDTO.parseDTO());
        }
        room.setSubjects(subjects);
        return room;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<SubjectDTO> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<SubjectDTO> subjectList) {
        this.subjectList = subjectList;
    }
}
