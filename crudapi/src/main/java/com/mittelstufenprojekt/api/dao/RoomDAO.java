package com.mittelstufenprojekt.api.dao;


import com.mittelstufenprojekt.api.domain.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface RoomDAO {
    void addRoom(Room room);
    Room getRoomById(Long id);
    void deleteRoom(Long id);

    List<Room> getFreeRoomsByDateTime(LocalDate date, LocalTime startTime, LocalTime endTime);

    List<Room> getFreeRoomsByDateTime(LocalDate date, LocalTime startTime, LocalTime endTime, Long subjectId);

    List<Room> getRoomsBySubject(Long subjectID);

}
