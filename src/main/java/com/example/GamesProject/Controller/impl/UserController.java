package com.example.GamesProject.Controller.impl;

import com.example.GamesProject.Repository.UserRepository;
import com.example.GamesProject.Service.impl.UserService;
import com.example.GamesProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ListResourceBundle;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }


//  ********** Get all Users + Find User ByID
    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }

    // ********** Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // ********** Update user info
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user)
    {
        return userService.updateUser(id, user);
    }

    // ********** Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User with ID " + id + " has been deleted.");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
