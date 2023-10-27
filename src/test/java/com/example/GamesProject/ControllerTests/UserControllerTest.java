package com.example.GamesProject.ControllerTests;
import com.example.GamesProject.Controller.impl.UserController;
import com.example.GamesProject.Service.impl.UserService;
import com.example.GamesProject.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testGetAllUsers() {
        List<User> mockUsers = Arrays.asList(new User(), new User());
        Mockito.when(userService.getAllUsers()).thenReturn(mockUsers);
        List<User> result = userController.getAllUsers();
        assertEquals(2, result.size());
    }

    @Test
    void testGetUserById() {
        long userId = 1L;
        User mockUser = new User();
        Mockito.when(userService.getUserById(userId)).thenReturn(mockUser);
        User result = userController.getUserById(userId);
        assertEquals(mockUser, result);
    }

    @Test
    void testCreateUser() {
        User newUser = new User();
        Mockito.when(userService.createUser(newUser)).thenReturn(newUser);
        User result = userController.createUser(newUser);
        assertEquals(newUser, result);
    }

    @Test
    void testUpdateUser() {
        long userId = 1L;
        User updatedUser = new User();
        Mockito.when(userService.updateUser(userId, updatedUser)).thenReturn(updatedUser);
        User result = userController.updateUser(userId, updatedUser);
        assertEquals(updatedUser, result);
    }

    @Test
    void testDeleteUser() {
        long userId = 1L;
        userController.deleteUser(userId);
        Mockito.verify(userService, Mockito.times(1)).deleteUser(userId);
    }
}
