package com.mittelstufenprojekt.api.service;

import com.mittelstufenprojekt.api.domain.Lesson;

import java.time.LocalDate;
import java.util.List;

public interface LessonService {

    List<Lesson> getLessonsByEmployee(LocalDate startDate, LocalDate endDate, Long personID);
    List<Lesson> getLessonsByCustomer(LocalDate startDate, LocalDate endDate, Long personID);


}
