package com.ticket.system.ticketsystembackend.service;

import com.ticket.system.ticketsystembackend.entity.User;
import com.ticket.system.ticketsystembackend.entity.Vendor;
import com.ticket.system.ticketsystembackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("User not found for id: " + id);
        }
    }

    public String deleteUserById(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted: " + id;
        } else {
            throw new RuntimeException("User not found for id: " + id);
        }
    }

    public int loginUser(String username, String password) {
        return 1;
    }
}
