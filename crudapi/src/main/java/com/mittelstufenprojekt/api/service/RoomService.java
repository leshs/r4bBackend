package com.mittelstufenprojekt.api.service;

import com.mittelstufenprojekt.api.domain.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room getRoomById(Long id);
    void addRoom(Room room);
}
