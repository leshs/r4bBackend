package com.mittelstufenprojekt.api.dao;

import com.mittelstufenprojekt.api.domain.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class LessonDAOImpl implements LessonDAO {
    @Autowired
    EntityManager entityManager;

    @Override
    public void addLesson(Lesson lesson) {
        //TODO
    }

    @Override
    public void deleteLesson(Long id) {
        //TODO
    }

    @Override
    public void updateLesson(Lesson lesson, Long id) {
        //TODO
    }

    @Override
    public List<Lesson> getLessonsBySubject(LocalDate startDate, LocalDate endDate, Long subjectID) {
        //TODO
        return null;
    }

    @Override
    public List<Lesson> getLessonsByCustomer(LocalDate startDate, LocalDate endDate, Long customerID) {
        TypedQuery<Lesson> query = entityManager.createNamedQuery("Lesson_By_Customer_Date", Lesson.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        query.setParameter("customerID", customerID);
        return query.getResultList();
    }

    @Override
    public List<Lesson> getLessonsByEmployee(LocalDate startDate, LocalDate endDate, Long employeeID) {
        TypedQuery<Lesson> query = entityManager.createNamedQuery("Lesson_By_Employee", Lesson.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        query.setParameter("employeeID", employeeID);
        return query.getResultList();
    }

    @Override
    public List<Lesson> getLessonByRoom(LocalDate startDate, LocalDate endDate, Long roomID) {
        //TODO
        return null;
    }

    @Override
    public void addCustomerToLesson(Long lessonID, Long customerID) {
        //TODO
    }
}
