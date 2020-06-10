package com.mittelstufenprojekt.api.dao;


import com.mittelstufenprojekt.api.domain.Lesson;

import java.time.LocalDate;
import java.util.List;

public interface LessonDAO {
    void addLesson(Lesson lesson);

    void deleteLesson(Long id);

    void updateLesson(Lesson lesson, Long id);

    List<Lesson> getLessonsBySubject(LocalDate startDate, LocalDate endDate, Long subjectID);

    List<Lesson> getLessonsByCustomer(LocalDate startDate, LocalDate endDate, Long customerID);

    List<Lesson> getLessonsByEmployee(LocalDate startDate, LocalDate endDate, Long employeeID);

    List<Lesson> getLessonByRoom(LocalDate startDate, LocalDate endDate, Long roomID);

    void addCustomerToLesson(Long lessonID, Long customerID);

}
