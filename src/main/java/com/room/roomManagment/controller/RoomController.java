package com.room.roomManagment.controller;

import com.room.roomManagment.entity.Room;
import com.room.roomManagment.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/room/{roomNumber}")
    public Optional<Room >getRoom(@PathVariable Integer roomNumber){
        return roomService.getRoom(roomNumber);

    }

    @GetMapping("/all")
    public List<Room>getAllRooms() {
        return roomService.getAllRooms();
    }


    @DeleteMapping("/delete/{roomNumber}")
    public ResponseEntity<String> deleteRoom(@PathVariable Integer roomNumber) {
        boolean isDeleted = roomService.deleteRoom(roomNumber);
        if (isDeleted) {
            return ResponseEntity.ok("Room deleted successfully!");
        }
        return ResponseEntity.badRequest().body("Room not found!");
    }

    @PostMapping("/add/room")
    public Room addRoom(@RequestBody Room room){
        Room roomResult=roomService.addRoom(room);
        return roomResult;

    }

  @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room) {

               Room newRoomNumber = roomService.updateRoom(room);
               return newRoomNumber;
  }

}





