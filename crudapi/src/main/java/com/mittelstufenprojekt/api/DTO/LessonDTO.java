package com.mittelstufenprojekt.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mittelstufenprojekt.api.domain.Customer;
import com.mittelstufenprojekt.api.domain.Lesson;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class LessonDTO {
    @JsonProperty
    private Long id;
    @JsonProperty
    private LocalDate date;
    @JsonProperty
    private LocalTime startTime;
    @JsonProperty
    private LocalTime endTime;
    @JsonProperty(value = "subject")
    private SubjectDTO subjectDTO;
    @JsonProperty(value ="employee")
    private PersonNameDTO employee;
    @JsonProperty(value ="customers")
    private List<PersonNameDTO> customerDTOList;
    @JsonProperty(value = "room")
    private RoomDTO roomDTO;

    public LessonDTO() {
    }

    public LessonDTO(Lesson lesson) {
        this.id = lesson.getId();
        this.date = lesson.getDate();
        this.startTime = lesson.getStartTime();
        this.endTime = lesson.getEndTime();
        this.subjectDTO = new SubjectDTO(lesson.getSubject());
        this.roomDTO = new RoomDTO(lesson.getBooking().getRoom());
        this.employee = new PersonNameDTO(lesson.getEmployee());
        this.customerDTOList = new ArrayList<>();
        List<Customer> customers = lesson.getCustomers();
        for(Customer customer: customers) {
            customerDTOList.add(new PersonNameDTO(customer));
        }
    }

    public Lesson parseDTO() {
        Lesson lesson = new Lesson();
        if(id != null) {
            lesson.setId(id);
        }
        lesson.setDate(date);
        lesson.setStartTime(startTime);
        lesson.setEndTime(endTime);
        lesson.setSubject(subjectDTO.parseDTO());
        //TODO employee setzen
        //TODO Customer setzen
        //Todo booking?
        return lesson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }

    public void setSubjectDTO(SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }

    public PersonNameDTO getEmployee() {
        return employee;
    }

    public void setEmployee(PersonNameDTO employee) {
        this.employee = employee;
    }

    public List<PersonNameDTO> getCustomerDTOList() {
        return customerDTOList;
    }

    public void setCustomerDTOList(List<PersonNameDTO> customerDTOList) {
        this.customerDTOList = customerDTOList;
    }

    public RoomDTO getRoomDTO() {
        return roomDTO;
    }

    public void setRoomDTO(RoomDTO roomDTO) {
        this.roomDTO = roomDTO;
    }
}
