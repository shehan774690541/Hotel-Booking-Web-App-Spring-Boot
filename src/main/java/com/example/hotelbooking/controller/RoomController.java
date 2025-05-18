package com.example.hotelbooking.controller;

// import com.example.hotelbooking.dto.RoomDto;
import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.response.ApiResponse;
import com.example.hotelbooking.service.RoomService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse add(@RequestBody Room dto) {
        return new ApiResponse(service.addRoom(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable int id, @RequestBody Room dto) {
        return new ApiResponse(service.editRoom(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable int id) {
        return new ApiResponse(service.deleteRoom(id));
    }

    @GetMapping
    public List<Room> list() {
        return service.listRooms();
    }
}
