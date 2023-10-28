package com.example.GamesProject.Service.impl;
import com.example.GamesProject.Controller.impl.UserController;
import com.example.GamesProject.Repository.GameLibraryRepository;
import com.example.GamesProject.Repository.UserRepository;
import com.example.GamesProject.Service.interfaces.IGameLibraryInterface;
import com.example.GamesProject.model.GamesLibrary;
import com.example.GamesProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GameLibraryService implements IGameLibraryInterface {
    private final GameLibraryRepository gameLibraryRepository;

@Autowired
UserRepository userRepository;

    @Autowired
    public GameLibraryService(GameLibraryRepository gameLibraryRepository) {
        this.gameLibraryRepository = gameLibraryRepository;
    }

    // ********** Get ALLGames + ByID + ByTitle + ByGenre
    public List<GamesLibrary> getAllGames()
    {
        return gameLibraryRepository.findAll();
    }
    public GamesLibrary getGameById(Long id) {
        Optional<GamesLibrary> game = gameLibraryRepository.findById(id);
        if (game.isPresent()) {
            return game.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game with ID " + id + " not found");
        }}
    @Override
    public List<GamesLibrary> getGamesByTitle(String title) {
        return gameLibraryRepository.findByTitleContainingIgnoreCase(title);
    }
    public List<GamesLibrary> getGamesByGenre(String genre) {
        return gameLibraryRepository.findByGenre(genre);
    }

    // ********** Post NewGames
    public GamesLibrary createGame(GamesLibrary newGame) {
        return gameLibraryRepository.save(newGame);
    }

    // ********** Update Game
    public GamesLibrary updateGame(Long id, GamesLibrary gamesLibrary) {
        Optional<GamesLibrary> optionalGame = gameLibraryRepository.findById(id);
        if (optionalGame.isPresent()) {
            GamesLibrary updateGame = optionalGame.get();
            updateGame.setRating(gamesLibrary.getRating());
            updateGame.setUser(gamesLibrary.getUser());
            return gameLibraryRepository.save(updateGame);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game with ID " + id + " not found");
    }

    // ********** Delete Game
    public boolean deleteGame(Long id) {
        if (gameLibraryRepository.existsById(id)) {
            gameLibraryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }}

}