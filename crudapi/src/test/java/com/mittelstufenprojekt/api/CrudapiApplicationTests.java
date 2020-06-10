package com.mittelstufenprojekt.api;

import com.mittelstufenprojekt.api.dao.PersonDAO;
import com.mittelstufenprojekt.api.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CrudapiApplicationTests {
    @Autowired
    EntityManager entityManager;

    @Autowired
    PersonDAO personDAO;

    @Test
    public void daoTest() {

    }

    @Test
    @Transactional
    @Rollback(false)
    public void safeCustomer() {
        Customer customer = new Customer();
        customer.setLastname("as");
        customer.setName("asd");
        entityManager.persist(customer);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void getCustomer() {
        Customer customer = entityManager.find(Customer.class, 2L);
        System.out.println(customer);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void safeRoom() {

        Room room = new Room();
        room.setInfo("springtest");
        entityManager.persist(room);
    }

    @Transactional
    @Rollback(false)
    @Test
    public void subjectTest() {
        Subject subject = new Subject("gitarre");
        entityManager.persist(subject);

    }

    @Test
    @Transactional
    @Rollback(false)
    public void testRoomQuery() {
        TypedQuery<Room> query = entityManager.createNamedQuery("Room_Find_All", Room.class);
        List<Room> result = query.getResultList();
        System.out.println(result);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void selectLessonByPerson() {
        //Date der Lessons: 2020-03-15
        TypedQuery<Lesson> query = entityManager.createNamedQuery("Lesson_By_Date_Span", Lesson.class);
        LocalDate startDate = LocalDate.parse("2020-03-13");
        LocalDate endDate = LocalDate.parse("2020-03-14");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        Object result = query.getResultList();
        System.out.println(result);
    }


    @Test
    @Transactional
    @Rollback(false)
    public void selectLessonByEmployee() {
        //Date der Lessons: 2020-03-15
        TypedQuery<Lesson> query = entityManager.createNamedQuery("Lesson_By_Employee", Lesson.class);
        LocalDate startDate = LocalDate.parse("2020-03-13");
        LocalDate endDate = LocalDate.parse("2020-03-20");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        query.setParameter("employeeID", 6L);
        Object result = query.getResultList();
        System.out.println(result);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void selectLessonByCustomer() {
        //Date der Lessons: 2020-03-15
        TypedQuery<Lesson> query = entityManager.createNamedQuery("Lesson_By_Customer_Date", Lesson.class);
        LocalDate startDate = LocalDate.parse("2020-03-13");
        LocalDate endDate = LocalDate.parse("2020-03-20");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        query.setParameter("customerID", 3L);
        Object result = query.getResultList();
        System.out.println(result);
    }


    @Test
    @Transactional
    @Rollback(false)
    public void testFreeRooms() {
        LocalTime lessonStart = LocalTime.of(1, 30);
        LocalTime lessonEnd = lessonStart.plusHours(1);
        LocalDate lessonDate = LocalDate.parse("2020-03-15");

        TypedQuery<Booking> find_booking_by_date = entityManager.createNamedQuery("Find_Booking_By_Date_Span", Booking.class);
        find_booking_by_date.setParameter("date", lessonDate);

        TypedQuery<Room> room_find_all = entityManager.createNamedQuery("Room_Find_All", Room.class);

        //query.setParameter("startTime", lessonStart);
        //query.setParameter("endTime", lessonEnd);
        List<Booking> bookings = find_booking_by_date.getResultList();
        List<Room> rooms = room_find_all.getResultList();
        List<Room> freeRooms = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            boolean free = true;
            Room roomTemp = rooms.get(i);
            for (int j = 0; j < bookings.size(); j++) {

                Booking booking = bookings.get(j);
                if (roomTemp.getId() != booking.getRoom().getId()) {
                    continue;
                }
                LocalTime bookingStart = booking.getStartTime();
                LocalTime bookingEnd = booking.getEndTime();
                if (lessonStart.isBefore(bookingStart) && lessonEnd.isAfter(bookingStart) ||
                        lessonStart.isBefore(bookingEnd) && lessonEnd.isAfter(bookingEnd) ||
                        lessonStart.equals(bookingStart) ||
                        lessonEnd.equals(bookingEnd)
                ) {
                    free = false;
                }
            }
            if (free) {
                freeRooms.add(roomTemp);
            }
        }

        System.out.println(freeRooms);
    }


    @Test
    @Transactional
    @Rollback(false)
    public void getAdress() {
        Address address = entityManager.find(Address.class, 3L);
        System.out.println(address);
    }

    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional
    @Rollback(false)
    public void wholeTableTest() throws ParseException {
        LocalTime lessonStart = LocalTime.of(1, 30);
        LocalTime lessonEnd = lessonStart.plusHours(1);
        LocalDate lessonDate = LocalDate.parse("2020-03-15");

        LocalDate contractStart = LocalDate.parse("2015-02-20");

        Account account = new Account("iban", "bic");
        Account account2 = new Account("iban2", "bic2");
        entityManager.persist(account);
        entityManager.persist(account2);

        Address address = new Address();
        address.setZipcode(123456);
        address.setCity("city");
        Address address2 = new Address();
        address.setZipcode(12);
        address.setCity("city2");
        entityManager.persist(address);
        entityManager.persist(address2);

        Customer customer1 = new Customer();
        customer1.setAccount(account2);
        customer1.setAddress(address2);
        customer1.setLastname("customer1");
        entityManager.persist(customer1);

        Subject gitarreSolo = new Subject("gitarreSolo");
        entityManager.persist(gitarreSolo);

        Room room1 = new Room("room1");
        room1.addSubject(gitarreSolo);
        entityManager.persist(room1);

        Tarif gitarreSoloTarif = new Tarif();
        gitarreSoloTarif.setSubject(gitarreSolo);
        gitarreSoloTarif.setPrice(100F);
        gitarreSoloTarif.setName("gitarre Solo Tarif");
        entityManager.persist(gitarreSoloTarif);

        Contract contractCustomer1 = new Contract();
        contractCustomer1.setCustomer(customer1);
        contractCustomer1.setTarif(gitarreSoloTarif);
        contractCustomer1.setStartDate(contractStart);
        entityManager.persist(contractCustomer1);

        Employee employee = new Employee();
        employee.setAddress(address);
        employee.setAccount(account);
        employee.setLastname("lastname");
        employee.setAdmin(true);
        employee.addSubject(gitarreSolo);
        entityManager.persist(employee);


        Lesson gitarreLesson1 = new Lesson();
        gitarreLesson1.setEmployee(employee);
        gitarreLesson1.addCustomer(customer1);
        gitarreLesson1.setSubject(gitarreSolo);
        gitarreLesson1.setTopic("Einführung");
        gitarreLesson1.setDate(lessonDate);
        gitarreLesson1.setStartTime(lessonStart);
        gitarreLesson1.setEndTime(lessonEnd);

        entityManager.persist(gitarreLesson1);

        Booking booking = new Booking();
        booking.setDate(lessonDate);
        booking.setStartTime(lessonStart);
        booking.setEndTime(lessonEnd);
        booking.setLesson(gitarreLesson1);
        booking.setRoom(room1);
        entityManager.persist(booking);

        Lesson lesson = entityManager.find(Lesson.class, 1L);
        System.out.println(lesson);
    }
}