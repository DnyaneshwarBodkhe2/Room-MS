package com.room.roomManagment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rId;

    private boolean isBooked;

    public Room(Integer rId, boolean isBooked) {
        this.rId = rId;
        this.isBooked = isBooked;
    }

    public Room() {
    }

    public Room(Integer roomNumber) {

    }

    public Integer getRoomNumber() {
        return rId;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.rId = roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "Room{" +
                "isBooked=" + isBooked +
                ", roomNumber=" + rId +
                '}';
    }
}
