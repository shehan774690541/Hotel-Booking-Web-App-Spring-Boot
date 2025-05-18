package com.example.hotelbooking.service;

import com.example.hotelbooking.dto.UserDto;
import com.example.hotelbooking.entity.User;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    private int nextId = 1;
    {
        User user1 = new User();
        user1.userId = 1;
        user1.fullName = "user full name";
        user1.position = "Administrator";
        user1.password = "1234";
        user1.editable = true;
        users.add(user1);

        User user2 = new User();
        user2.userId = 2;
        user2.fullName = "user full name";
        user2.position = "Receptionist";
        user2.password = "1234";
        user2.editable = true;
        users.add(user2);

        User user3 = new User();
        user3.userId = 3;
        user3.fullName = "user full name";
        user3.position = "Receptionist";
        user3.password = "1234";
        user3.editable = true;
        users.add(user3);

        User user4 = new User();
        user4.userId = 4;
        user4.fullName = "user full name";
        user4.position = "Manager";
        user4.password = "1234";
        user4.editable = false;
        users.add(user4);
        nextId = 5;
    }

    public String addUser(UserDto dto) {
        User user = new User();
        user.userId = nextId++;
        user.fullName = dto.fullName;
        user.position = dto.position;
        user.password = dto.password;
        users.add(user);
        return "User added successfully";
    }

    public String editUser(int id, UserDto dto) {
        for (User u : users) {
            if (u.userId == id) {
                u.fullName = dto.fullName;
                u.editable = dto.editable;
                return "User edited successfully";
            }
        }
        return "User not found";
    }

    public String deleteUser(int id) {
        users.removeIf(u -> u.userId == id);
        return "User deleted successfully";
    }

    public List<User> listUsers() {
        return users;
    }
}
