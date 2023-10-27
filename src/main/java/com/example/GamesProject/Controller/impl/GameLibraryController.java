package com.example.GamesProject.Controller.impl;
import com.example.GamesProject.Service.impl.GameLibraryService;
import com.example.GamesProject.model.GamesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/games")
    public class GameLibraryController {
    private final GameLibraryService gameLibraryService;

    @Autowired
    public GameLibraryController(GameLibraryService gamesLibraryService) {
        this.gameLibraryService = gamesLibraryService;
    }

    @GetMapping
    public List<GamesLibrary> getAllGames() {
        return gameLibraryService.getAllGames();
    }

    @GetMapping("/{id}")
    public GamesLibrary getGameById(@PathVariable Long id) {
        return gameLibraryService.getGameById(id);
    }

    @PostMapping
    public GamesLibrary createGame(@RequestBody GamesLibrary newGame) {
        return gameLibraryService.createGame(newGame);
    }

    @PutMapping("/{id}")
    public GamesLibrary updateGame(@PathVariable Long id, @RequestBody GamesLibrary gamesLibrary) {
        return gameLibraryService.updateGame(id, gamesLibrary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable Long id) {
        boolean deleted = gameLibraryService.deleteGame(id);
        if (deleted) {
            return ResponseEntity.ok("Game with ID " + id + " has been deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // ... (previous methods)

    @GetMapping("/search")
    public List<GamesLibrary> getGamesByTitle(@RequestParam("title") String title) {
        return gameLibraryService.getGamesByTitle(title);
    }
    @GetMapping("/search1")
    public List<GamesLibrary> searchGamesByGenre(@RequestParam String genre) {
        return gameLibraryService.getGamesByGenre(genre);
    }

}

