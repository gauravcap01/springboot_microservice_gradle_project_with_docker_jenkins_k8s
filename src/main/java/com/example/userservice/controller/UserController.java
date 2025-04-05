package com.example.userservice.controller;

import com.example.userservice.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        // Simple mock data
        return new User(id, "John Doe", "john@example.com");
    }
}