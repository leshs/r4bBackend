package com.mittelstufenprojekt.api;

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
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DBTest {
    @Autowired
    private EntityManager entityManager;


    @Transactional
    @Rollback(false)
    @Test
    public void subjectTest() {
        Subject subject = new Subject("gitarre");
        entityManager.persist(subject);

    }

    @Transactional
    @Test
    public void testRoomQuery() {

        TypedQuery<Room> query = entityManager.createNamedQuery("Room_Find_All", Room.class);
        List<Room> result = query.getResultList();
        System.out.println(result);
    }

    /*
        @Test
        public void passwordTest() throws NoSuchAlgorithmException {
            String hash = "35454B055CC325EA1AF2126E27707052";
            String password = "ILoveJava";
            String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
            System.out.println(md5Hex);

        }


     */
    @Transactional
    @Rollback(false)
    @Test
    public void wholeTableTest() throws ParseException {
        LocalTime lessonStart = LocalTime.of(1, 30);
        LocalTime lessonEnd = lessonStart.plusHours(1);
        LocalDate lessonDate = LocalDate.parse("2020-03-15");

        LocalDate contractStart = LocalDate.parse("2015-02-20");

        Account account = new Account("iban", "bic");
        Account account2 = new Account("iban2", "bic2");
        account.setFirstname("jlk");
        account.setLastname("lastnameone");
        account2.setFirstname("2");
        account2.setLastname("2");
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
        customer1.setLastname("lastname");
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
        employee.setSalary(100F);
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

    @Transactional
    @Test
    public void addExistingSubjectToRoom() {
        Subject subject = new Subject();
        subject.setId(2L);
        Room roomTest = new Room();
        subject = entityManager.find(Subject.class, subject.getId());
        roomTest.addSubject(subject);
        roomTest.setInfo("neuer test");
        entityManager.persist(roomTest);
    }

    @Transactional
    @Test
    public void employeeSubjectTest() {
        Account account = new Account("iban", "bic");
        entityManager.persist(account);

        Address address = new Address();
        address.setZipcode(123456);
        address.setCity("city");
        entityManager.persist(address);

        Employee employee = new Employee();
        employee.setAddress(address);
        employee.setAccount(account);
        employee.setLastname("lastname");
        employee.setAdmin(true);

        Subject gitarre = new Subject("gitarre");
        Subject klavier = new Subject("klavier");
        employee.addSubject(gitarre);
        employee.addSubject(klavier);


        entityManager.persist(employee);


    }

    @Transactional
    @Test
    public void testDate() {
        Date date = new Date();
        System.out.println(date);
    }
}
