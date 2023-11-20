package com.example.GamesProject.Service.impl;

import com.example.GamesProject.Repository.GameLibraryRepository;
import com.example.GamesProject.model.GameStatus;
import com.example.GamesProject.model.GamesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.GamesProject.model.GameStatus;
import java.util.List;
import java.util.Optional;
import com.example.GamesProject.model.GameStatus;

@Service
public class GameLibraryService {
    private final GameLibraryRepository gameLibraryRepository;

    @Autowired
    public GameLibraryService(GameLibraryRepository gameLibraryRepository) {
        this.gameLibraryRepository = gameLibraryRepository;
    }

    // Get All Games
    public List<GamesLibrary> getAllGames() {
        return gameLibraryRepository.findAll();
    }

    // Get Game by ID
    public GamesLibrary getGameById(Long id) {
        Optional<GamesLibrary> game = gameLibraryRepository.findById(id);
        return game.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game with ID " + id + " not found"));
    }

    // Get Games by Title
    public List<GamesLibrary> getGamesByTitle(String title) {
        return gameLibraryRepository.findByTitleContainingIgnoreCase(title);
    }

    // Get Games by Genre
    public List<GamesLibrary> getGamesByGenre(String genre) {
        return gameLibraryRepository.findByGenre(genre);
    }

    // Create New Game
    public GamesLibrary createGame(GamesLibrary newGame) {
        return gameLibraryRepository.save(newGame);
    }

    // Update Game
    public GamesLibrary updateGame(Long id, GamesLibrary updatedGame) {
        Optional<GamesLibrary> optionalGame = gameLibraryRepository.findById(id);
        if (optionalGame.isPresent()) {
            GamesLibrary existingGame = optionalGame.get();
            existingGame.setTitle(updatedGame.getTitle());
            existingGame.setRating(updatedGame.getRating());
//            existingGame.setUser(updatedGame.getUser());
            // Set other attributes as needed
            return gameLibraryRepository.save(existingGame);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game with ID " + id + " not found");
    }



    // Delete Game
    public boolean deleteGame(Long id) {
        if (gameLibraryRepository.existsById(id)) {
            gameLibraryRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public void setStatusOfGame(Long id, GameStatus status) {
    }
}
