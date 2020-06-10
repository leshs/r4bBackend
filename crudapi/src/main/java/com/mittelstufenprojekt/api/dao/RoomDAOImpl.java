package com.mittelstufenprojekt.api.dao;

import com.mittelstufenprojekt.api.domain.Booking;
import com.mittelstufenprojekt.api.domain.Room;
import com.mittelstufenprojekt.api.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomDAOImpl implements RoomDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public Room getRoomById(Long id) {
        return entityManager.find(Room.class, id);
    }

    @Override
    public void deleteRoom(Long id) {
        //TODO
    }

    @Override
    public void addRoom(Room room) {
        for (int i = 0; i < room.getSubjects().size(); i++) {
            Subject subject = room.getSubjects().get(i);
            room.getSubjects().set(i, entityManager.find(Subject.class, subject.getId()));
        }
        entityManager.persist(room);
    }

    @Override
    public List<Room> getFreeRoomsByDateTime(LocalDate date, LocalTime startTime, LocalTime endTime) {
        return getFreeRoomsByDateTime(date, startTime, endTime, null);
    }

    @Override
    public List<Room> getFreeRoomsByDateTime(LocalDate date, LocalTime startTime, LocalTime endTime, Long subjectId) {
        TypedQuery<Booking> find_booking_by_date = entityManager.createNamedQuery("Find_Booking_By_Date", Booking.class);
        find_booking_by_date.setParameter("date", date);
        TypedQuery<Room> room_find_all = entityManager.createNamedQuery("Room_Find_All", Room.class);
        List<Booking> bookings = find_booking_by_date.getResultList();
        List<Room> rooms = room_find_all.getResultList();
        List<Room> freeRooms = new ArrayList<>();

        //Check if the room is available and is suited for the subject
        for(int i = 0; i < rooms.size(); i++) {
            boolean free = true;
            boolean hasSubject = false;
            Room roomTemp = rooms.get(i);
            if(subjectId != null) {
                List<Subject> subjectList = roomTemp.getSubjects();

                for(int j = 0; j < subjectList.size(); j++) {
                    if(subjectId.equals(subjectList.get(i).getId())) {
                        hasSubject = true;
                         break;
                    }
                }
            } else {
                hasSubject = true;
            }
            if(!hasSubject) {
                continue;
            }
            for(int j = 0; j < bookings.size(); j++) {

                Booking booking = bookings.get(j);
                if(roomTemp.getId() != booking.getRoom().getId()) {
                    continue;
                }
                LocalTime bookingStart = booking.getStartTime();
                LocalTime bookingEnd = booking.getEndTime();
                if(startTime.isBefore(bookingStart) && endTime.isAfter(bookingStart) ||
                        startTime.isBefore(bookingEnd) && endTime.isAfter(bookingEnd) ||
                        startTime.equals(bookingStart) ||
                        endTime.equals(bookingEnd)
                )
                {
                    free = false;
                }
            }
            if(free) {
                freeRooms.add(roomTemp);
            }
        }
        return freeRooms;
    }

    @Override
    public List<Room> getRoomsBySubject(Long subjectID) {
        //TODO
        return null;
    }
}
