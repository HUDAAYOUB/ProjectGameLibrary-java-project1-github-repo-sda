package com.example.GamesProject.RepositoryTest;

import com.example.GamesProject.Repository.UserRepository;
import com.example.GamesProject.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        String username = "tester";
        User user = new User();
        user.setUsername(username);
        userRepository.save(user);

        User foundUser = userRepository.findByUsername(username);
        assertNotNull(foundUser);
        assertEquals(username, foundUser.getUsername());
    }

}