package com.example.GamesProject.RepositoryTest;

import com.example.GamesProject.Repository.UserRepository;
import com.example.GamesProject.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


}