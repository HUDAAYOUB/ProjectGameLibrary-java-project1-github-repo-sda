package com.example.GamesProject.Service.impl;
import com.example.GamesProject.Controller.impl.UserController;
import com.example.GamesProject.Repository.GameLibraryRepository;
import com.example.GamesProject.Repository.UserRepository;
import com.example.GamesProject.Service.interfaces.IGameLibraryInterface;
import com.example.GamesProject.model.GamesLibrary;
import com.example.GamesProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public List<GamesLibrary> getAllGames()
    {
        return gameLibraryRepository.findAll();
    }


    public GamesLibrary getGameById(Long id)
    {
        return gameLibraryRepository.findById(id).orElse(null);
    }


    public GamesLibrary createGame(GamesLibrary newGame) {
//        Optional<User> userGames = userRepository.findById(newGame.getUserId());
//        if (userGames.isEmpty()) return null;
//        User user = userGames.get();
//        user.getGamesLibrary().add(newGame);
//        userRepository.save(user);
        return gameLibraryRepository.save(newGame);
    }

    public GamesLibrary updateGame(Long id, GamesLibrary gamesLibrary) {
        GamesLibrary updateGame = gameLibraryRepository.findById(id).orElse(null);
        if (updateGame != null) {
            updateGame.setStatus(updateGame.getStatus());
            updateGame.setRating(updateGame.getRating());
//            updateGame.setReview(updateGame.getReview());
            return gameLibraryRepository.save(updateGame);

        }
        return null;
    }
    public boolean deleteGame(Long id) {
        if (gameLibraryRepository.existsById(id)) {
            gameLibraryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }}

}