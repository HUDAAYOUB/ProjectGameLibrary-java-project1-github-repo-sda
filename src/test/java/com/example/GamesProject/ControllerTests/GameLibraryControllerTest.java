package com.example.GamesProject.ControllerTests;
import com.example.GamesProject.Controller.impl.GameLibraryController;
import com.example.GamesProject.Service.impl.GameLibraryService;
import com.example.GamesProject.model.GamesLibrary;
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
public class GameLibraryControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Mock
    private GameLibraryService gameLibraryService;

    @InjectMocks
    private GameLibraryController gameLibraryController;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testGetAllGames() {
        List<GamesLibrary> mockGames = Arrays.asList(new GamesLibrary(), new GamesLibrary());
        Mockito.when(gameLibraryService.getAllGames()).thenReturn(mockGames);
        List<GamesLibrary> result = gameLibraryController.getAllGames();
        assertEquals(2, result.size());
    }

    @Test
    void testGetGameById() {
        long gameId = 1L;
        GamesLibrary mockGame = new GamesLibrary();
        Mockito.when(gameLibraryService.getGameById(gameId)).thenReturn(mockGame);
        GamesLibrary result = gameLibraryController.getGameById(gameId);
        assertEquals(mockGame, result);
    }


}
