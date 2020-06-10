package com.mittelstufenprojekt.api.controller;

import com.mittelstufenprojekt.api.DTO.LessonDTO;
import com.mittelstufenprojekt.api.DTO.LessonPersonRequestDTO;
import com.mittelstufenprojekt.api.DTO.PersonNameDTO;
import com.mittelstufenprojekt.api.DTO.RoomDTO;
import com.mittelstufenprojekt.api.domain.Customer;
import com.mittelstufenprojekt.api.domain.Lesson;
import com.mittelstufenprojekt.api.service.LessonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//TODO Parse Lesson entfernen

@RestController
@RequestMapping("/api/lesson")
public class LessonController {

    @Autowired
    LessonService lessonService;


    @Operation(summary = "get lessons by employee",
            description = "returns all lessons for a employee in a given time span",
            tags = "lesson-controller")
    @GetMapping("/employee")
    public List<LessonDTO> getLessonsByEmployee(@RequestBody LessonPersonRequestDTO lessonRequest) {
        List<Lesson> lessons = lessonService.getLessonsByEmployee(lessonRequest.getStartDate(), lessonRequest.getEndDate(), lessonRequest.getPersonID());
        return lessons.stream()
                .map(this::parseLesson)
                .collect(Collectors.toList());
    }



    @Operation(summary = "get lessons by customer",
            description = "returns all lessons for a customer in a given time span",
            tags = "lesson-controller")
    @GetMapping("/customer")
    public List<LessonDTO> getLessonsByustomer(@RequestBody LessonPersonRequestDTO lessonRequest) {
        List<Lesson> lessons = lessonService.getLessonsByCustomer(lessonRequest.getStartDate(), lessonRequest.getEndDate(), lessonRequest.getPersonID());
        return lessons.stream()
                .map(this::parseLesson)
                .collect(Collectors.toList());
    }



    private LessonDTO parseLesson(Lesson lesson) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setInfo(lesson.getBooking().getRoom().getInfo());
        roomDTO.setId(lesson.getBooking().getRoom().getId());
        roomDTO.setCapacity(lesson.getBooking().getRoom().getCapacity());

        PersonNameDTO employee = new PersonNameDTO();
        employee.setFirstname(lesson.getEmployee().getName());
        employee.setLastname(lesson.getEmployee().getLastname());
        employee.setId(lesson.getEmployee().getId());

        List<PersonNameDTO> customersDTO = new ArrayList<>();
        List<Customer> customers = lesson.getCustomers();
        for(int i = 0; i < customers.size(); i++) {
            PersonNameDTO personNameDTO = new PersonNameDTO();
            personNameDTO.setId(customers.get(i).getId());
            personNameDTO.setLastname(customers.get(i).getLastname());
            personNameDTO.setFirstname(customers.get(i).getName());
            customersDTO.add(personNameDTO);
        }


        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setRoomDTO(roomDTO);
        lessonDTO.setDate(lesson.getDate());
        lessonDTO.setStartTime(lesson.getStartTime());
        lessonDTO.setEndTime(lesson.getEndTime());
        lessonDTO.setEmployee(employee);
        lessonDTO.setCustomerDTOList(customersDTO);

        return lessonDTO;
    }

}
