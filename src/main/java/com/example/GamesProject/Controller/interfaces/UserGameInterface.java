package com.example.GamesProject.Controller.interfaces;

import com.example.GamesProject.model.UserGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserGameInterface  {


    UserGame findByUserIdAndGameId(Long userId, Long gameId);

    void deleteByUserIdAndGameId(Long userId, Long gameId);
    public Optional<UserGame> getUserGame(Long userId, Long gameId);

}
