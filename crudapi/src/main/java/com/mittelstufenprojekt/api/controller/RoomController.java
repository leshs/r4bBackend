package com.mittelstufenprojekt.api.controller;

import com.mittelstufenprojekt.api.DTO.RoomDTO;
import com.mittelstufenprojekt.api.DTO.SubjectDTO;
import com.mittelstufenprojekt.api.domain.Room;
import com.mittelstufenprojekt.api.domain.Subject;
import com.mittelstufenprojekt.api.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    RoomService roomService;


    @Operation(summary = "add room",
            description = "adds a new room with specified subjects",
            tags = "room-controller")
    @PutMapping("/add")
    public void addRoom(@RequestBody RoomDTO roomDTO) {
        roomService.addRoom(transformRoomDTO(roomDTO));
    }



    @Operation(summary = "get all rooms",
            description = "returns all rooms",
            tags = "room-controller")
    @GetMapping("/all")
    public List<RoomDTO> getAllRooms() {
        List<RoomDTO> roomDTOList = new ArrayList<>();
        List<Room> allRooms = roomService.getAllRooms();
        for(int i = 0; i < allRooms.size(); i++) {
            roomDTOList.add(transformRoom(allRooms.get(i)));
        }
        return roomDTOList;
    }

    @Operation(summary = "get room",
            description = "returns a specific room by id",
            tags = "room-controller")
    @GetMapping("/{id}")
    public RoomDTO getRoomById(@PathVariable int id) {
        return transformRoom(roomService.getRoomById((long) id));
    }


    public RoomDTO transformRoom(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setCapacity(room.getCapacity());
        roomDTO.setId(room.getId());
        roomDTO.setInfo(room.getInfo());
        List<SubjectDTO> subjectDTOList =new ArrayList<>();
        List<Subject> subjects = room.getSubjects();
        for(int i = 0; i < subjects.size(); i++) {
            Subject subject = subjects.get(i);
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setId(subject.getId());
            subjectDTO.setInfo(subject.getInfo());
            subjectDTO.setName(subject.getName());
            subjectDTOList.add(subjectDTO);
        }
        roomDTO.setSubjectList(subjectDTOList);
        return roomDTO;
    }

    public Room transformRoomDTO(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setCapacity(roomDTO.getCapacity());
        room.setInfo(roomDTO.getInfo());
        List<Subject> subjectList = new ArrayList<>();
        for(int i = 0; i < roomDTO.getSubjectList().size(); i++) {
            SubjectDTO subjectDTO = roomDTO.getSubjectList().get(i);
            Subject subject = new Subject();
            subject.setId(subjectDTO.getId());
        }
        room.setSubjects(subjectList);
        return room;
    }
}
