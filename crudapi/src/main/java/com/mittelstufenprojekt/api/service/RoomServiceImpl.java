package com.mittelstufenprojekt.api.service;

import com.mittelstufenprojekt.api.dao.RoomDAO;
import com.mittelstufenprojekt.api.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl  implements RoomService {
    @Autowired
    private RoomDAO roomDAO;

    @Override
    public List<Room> getAllRooms() {
        //TODO
        return null;
    }

    @Override
    public Room getRoomById(Long id) {
        return roomDAO.getRoomById(id);
    }

    @Override
    public void addRoom(Room room) {
        roomDAO.addRoom(room);
    }
}
