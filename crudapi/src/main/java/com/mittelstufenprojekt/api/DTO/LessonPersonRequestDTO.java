package com.mittelstufenprojekt.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class LessonPersonRequestDTO {
    @JsonProperty
    private Long personID;
    @JsonProperty
    private LocalDate startDate;
    @JsonProperty
    private  LocalDate endDate;

    public Long getPersonID() {
        return personID;
    }

    public void setPersonID(Long personID) {
        this.personID = personID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
