package com.example.hotelbooking.controller;

import com.example.hotelbooking.dto.UserDto;
import com.example.hotelbooking.entity.User;
import com.example.hotelbooking.response.ApiResponse;
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

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable int id, @RequestBody UserDto dto) {
        return new ApiResponse(service.editUser(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable int id) {
        return new ApiResponse(service.deleteUser(id));
    }

    @GetMapping
    public List<User> list() {
        return service.listUsers();
    }
}
