package com.example.hotelbooking.controller;

import com.example.hotelbooking.dto.UserDeleteDto;
import com.example.hotelbooking.dto.UserDto;
import com.example.hotelbooking.entity.User;
import com.example.hotelbooking.response.ApiResponse;
import com.example.hotelbooking.entity.BaseResponce;
import com.example.hotelbooking.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse add(@RequestBody UserDto dto) {
        return new ApiResponse(service.addUser(dto));
    }

    @PostMapping("/list")
    public List<User> List() {
        return service.listUsers();
    }

    // Endpoint to delete a user: POST /api/users/delete
    // Example JSON request body:
    // {
    //   "userId": 123
    // }
    @PostMapping("/delete")
    public BaseResponce delete(@RequestBody UserDeleteDto dto) {
        return service.deleteUser(dto);
    }

    @GetMapping
    public List<User> list() {
        return service.listUsers();
    }
}
