package com.example.GamesProject.Controller.impl;

import com.example.GamesProject.Repository.UserRepository;
import com.example.GamesProject.Service.impl.UserGameService;
import com.example.GamesProject.Service.impl.UserService;
import com.example.GamesProject.model.GameStatus;
import com.example.GamesProject.model.User;
import com.example.GamesProject.model.UserGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ListResourceBundle;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserGameService userGameService;
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // for Getting all Users in Postman
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // Find the user by searching with id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUser(username);
    }


    // Create a new user from postman
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/{userId}/addgame/{gameId}")
    public User addGameToUser(@PathVariable Long userId, @PathVariable Long gameId,
                              @RequestParam int userRating, @RequestParam String userOpinion,
                              @RequestParam GameStatus status) {
        return userService.addGameToUser(userId, gameId, userRating, userOpinion, status);
    }


    // Update user info the logic in Service class
//    @PutMapping("/{userGameId}")
//    public ResponseEntity<UserGame> updateUserGame(
//            @PathVariable Long userGameId,
//            @RequestBody UserGame updatedUserGame) {
//
//        UserGame existingUserGame = userGameService.findById(userGameId);
//
//        if (existingUserGame != null) {
//            // Update the fields you want to allow to be updated
//            existingUserGame.setUserRating(updatedUserGame.getUserRating());
//            existingUserGame.setUserOpinion(updatedUserGame.getUserOpinion());
//            existingUserGame.setStatus(updatedUserGame.getStatus());
//
//            UserGame savedUserGame = userGameService.save(existingUserGame);
//            return new ResponseEntity<>(savedUserGame, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }

    // Delete user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
