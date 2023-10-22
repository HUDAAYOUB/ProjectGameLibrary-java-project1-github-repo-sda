package com.example.GamesProject.Service.impl;

import com.example.GamesProject.Controller.interfaces.IUserInterface;
import com.example.GamesProject.Repository.UserRepository;
import com.example.GamesProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



    @Service
    public class UserService implements IUserInterface {

        @Autowired
       UserRepository userRepository;

        @Override
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }
        @Override
        public User getUserById(Long id) {
            return userRepository.findById(id).orElse(null);
        }

        @Override
        public User createUser(User user) {
            return userRepository.save(user);
        }

// ****** Logic for updating user info

        @Override
        public User updateUser (Long id ,User user) {
            User updateUser = userRepository.findById(id).orElse(null);
            if (updateUser != null) {
                updateUser.setUsername(user.getUsername());
                updateUser.setEmail(user.getEmail());
                updateUser.setPassword(user.getPassword());
                return userRepository.save(updateUser);

            }
            return null;
        }

        @Override
        public void deleteUser(Long id) {
            userRepository.deleteById(id);
        }

    }

