package com.room.roomManagment.service;

import com.room.roomManagment.entity.Room;
import com.room.roomManagment.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Optional<Room> getRoom(@PathVariable Integer roomNumber) {
        return roomRepository.findById(roomNumber);

    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }


    public boolean deleteRoom(Integer roomNumber) {
        Optional<Room> room = roomRepository.findById(roomNumber);
        if (room.isPresent()) {
            roomRepository.deleteById(roomNumber);
            return true;
        }
        return false;
    }

    public Room addRoom(Room room){
        Room newRoom = roomRepository.save(room);
        return newRoom;

    }

    public Room updateRoom(@RequestBody Room room){

        Optional<Room> existingRoom = roomRepository.findById(room.getRoomNumber());
        if(existingRoom.isPresent()){
            existingRoom.get().setRoomNumber(room.getRoomNumber());
            existingRoom.get().setBooked(room.isBooked());
            return roomRepository.save(existingRoom.get());
        }
        else{
            {
                throw new RuntimeException("Room with number " + room  + " not found.");
            }
        }



    }

}











