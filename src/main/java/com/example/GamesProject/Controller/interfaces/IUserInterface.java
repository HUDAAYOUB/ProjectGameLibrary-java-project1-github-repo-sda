package com.example.GamesProject.Controller.interfaces;

import com.example.GamesProject.model.User;

import java.util.List;

public interface IUserInterface {

    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);

}