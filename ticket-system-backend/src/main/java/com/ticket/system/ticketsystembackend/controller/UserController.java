package com.ticket.system.ticketsystembackend.controller;

import com.ticket.system.ticketsystembackend.entity.User;
import com.ticket.system.ticketsystembackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/get-users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get-user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PutMapping("/update-user")
    public User updateUserById(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        String name = userService.loginUser(user.getName(), user.getPassword());
        return name;
    }
}
