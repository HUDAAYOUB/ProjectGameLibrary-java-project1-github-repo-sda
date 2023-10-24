package com.example.GamesProject.ControllerTests;

import com.example.GamesProject.Controller.impl.GameLibraryController;
import com.example.GamesProject.Service.impl.GameLibraryService;
import com.example.GamesProject.model.GamesLibrary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GameLibraryControllerTest {

    @Mock
    private GameLibraryService gameLibraryService;

    @InjectMocks
    private GameLibraryController gameLibraryController;

    @BeforeEach
    void setUp() {
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

    @Test
    void testCreateGame() {
        GamesLibrary newGame = new GamesLibrary();
        Mockito.when(gameLibraryService.createGame(newGame)).thenReturn(newGame);
        GamesLibrary result = gameLibraryController.createGame(newGame);
        assertEquals(newGame, result);
    }

    @Test
    void testUpdateGame() {
        long gameId = 1L;
        GamesLibrary updatedGame = new GamesLibrary();
        Mockito.when(gameLibraryService.updateGame(gameId, updatedGame)).thenReturn(updatedGame);
        GamesLibrary result = gameLibraryController.updateGame(gameId, updatedGame);
        assertEquals(updatedGame, result);
    }

    @Test
    void testDeleteGame() {
        long gameId = 1L;
        Mockito.when(gameLibraryService.deleteGame(gameId)).thenReturn(true);
        ResponseEntity<String> responseEntity = gameLibraryController.deleteGame(gameId);
        assertEquals("Game with ID " + gameId + " has been deleted.", responseEntity.getBody());
    }

    @Test
    void testDeleteGameNotFound() {
        long gameId = 1L;
        Mockito.when(gameLibraryService.deleteGame(gameId)).thenReturn(false);
        ResponseEntity<String> responseEntity = gameLibraryController.deleteGame(gameId);
        assertEquals(404, responseEntity.getStatusCodeValue());
    }
}