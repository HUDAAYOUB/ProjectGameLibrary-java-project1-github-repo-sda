package com.example.GamesProject.Controller.impl;
import com.example.GamesProject.Repository.UserGameRepository;
import com.example.GamesProject.Service.impl.UserGameService;
import com.example.GamesProject.model.GameStatus;
import com.example.GamesProject.model.User;
import com.example.GamesProject.model.UserGame;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserGameController {

    private UserGameService userGameService;

@Autowired
    UserGameRepository userGameRepository;
    @Autowired
    public UserGameController(UserGameService userGameService) {
        this.userGameService = userGameService;
    }


    @DeleteMapping("/{userId}/games/{gameId}")
    public void deleteGameFromUser(@PathVariable Long userId, @PathVariable Long gameId) {
        boolean deleted = userGameService.deleteGameFromUser(userId, gameId);
        if (!deleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found for user with ID " + userId);
        }
    }

    @PostMapping("/{userId}/games/{gameId}")
    public User createGame(@PathVariable Long userId, @PathVariable Long gameId,
                           @RequestParam int userRating, @RequestParam String userOpinion,
                           @RequestParam GameStatus status) {
        UserGame newUserGame = userGameService.createUserGame(userId, gameId, userRating, userOpinion, status);
        return newUserGame.getUser(); //ResponseEntity.ok("Game created for user with ID " + userId + " and game ID " + gameId);
    }

    @PutMapping("/{userId}/games/{gameId}")
    public void updateGame(@PathVariable Long userId, @PathVariable Long gameId,
                                             @RequestBody UserGame request) {
        UserGame userGame = userGameRepository.findByUserIdAndGameId(userId, gameId);

        if (userGame != null) {

            userGame.setUserRating(request.getUserRating());
            userGame.setUserOpinion(request.getUserOpinion());
            userGame.setStatus(request.getStatus());

            userGameRepository.save(userGame);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found for user with ID " + userId);
        }
    }



}





