package com.example.hotelbooking.service;

// import com.example.hotelbooking.dto.RoomDto;
import com.example.hotelbooking.entity.Room;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RoomService {
    private final List<Room> rooms = new ArrayList<>();
    private int nextId = 1;

    public String addRoom(Room dto) {
        Room room = new Room();
        room.id = nextId++;
        room.roomNumber = dto.roomNumber;
        room.type = dto.type;
        rooms.add(room);
        return "Room added successfully";
    }

    public String editRoom(int id, Room dto) {
        for (Room r : rooms) {
            if (r.id == id) {
                r.roomNumber = dto.roomNumber;
                r.type = dto.type;
                return "Room edited successfully";
            }
        }
        return "Room not found";
    }

    public String deleteRoom(int id) {
        rooms.removeIf(r -> r.id == id);
        return "Room deleted successfully";
    }

    public List<Room> listRooms() {
        return rooms;
    }
}
