package com.mittelstufenprojekt.api.service;

import com.mittelstufenprojekt.api.dao.LessonDAO;
import com.mittelstufenprojekt.api.domain.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService{
    @Autowired
    private LessonDAO lessonDAO;

    @Override
    public List<Lesson> getLessonsByEmployee(LocalDate startDate, LocalDate endDate, Long personID) {
        return lessonDAO.getLessonsByEmployee(startDate, endDate, personID);
    }

    @Override
    public List<Lesson> getLessonsByCustomer(LocalDate startDate, LocalDate endDate, Long personID) {
        return lessonDAO.getLessonsByCustomer(startDate, endDate, personID);
    }
}
