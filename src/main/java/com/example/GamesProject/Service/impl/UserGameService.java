package com.example.GamesProject.Service.impl;

import com.example.GamesProject.Repository.UserGameRepository;
import com.example.GamesProject.Repository.UserRepository;
import com.example.GamesProject.model.User;
import com.example.GamesProject.model.UserGame;
import com.example.GamesProject.model.GameStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserGameService {

        private final UserGameRepository userGameRepository;
        private final UserRepository userRepository;

        @Autowired

        public UserGameService(UserGameRepository userGameRepository, UserRepository userRepository) {
                this.userGameRepository = userGameRepository;
                this.userRepository = userRepository;
        }
// Delete game from user profile
        public boolean deleteGameFromUser(Long userId, Long gameId) {
                Optional<User> optionalUser = userRepository.findById(userId);

                if (optionalUser.isPresent()) {
                        User user = optionalUser.get();

                        user.removeUserGame(gameId);

                        userRepository.save(user);
                        return true;
                } else {
                        return false;
                }
        }

        // Add game to user
        public UserGame createUserGame(Long userId, Long gameId, int userRating, String userOpinion, GameStatus status) {
                UserGame userGame = new UserGame();

                userGame.setUserRating(userRating);
                userGame.setUserOpinion(userOpinion);
                userGame.setStatus(status);

                return userGameRepository.save(userGame);
        }

        // Update the game card in userprofile
        public boolean updateUserGame(Long userId, Long gameId, int userRating, String userOpinion, GameStatus status) {
                UserGame userGame = userGameRepository.findByUserIdAndGameId(userId, gameId);
                if (userGame != null) {
                        userGame.setUserRating(userRating);
                        userGame.setUserOpinion(userOpinion);
                        userGame.setStatus(status);
                        userGameRepository.save(userGame);
                        return true;
                }
                return false;
        }


}