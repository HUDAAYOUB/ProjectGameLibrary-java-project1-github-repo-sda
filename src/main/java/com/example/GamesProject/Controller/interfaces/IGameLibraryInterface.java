package com.example.GamesProject.Controller.interfaces;

import com.example.GamesProject.model.GamesLibrary;

import java.util.List;

public interface IGameLibraryInterface  {
    List<GamesLibrary> getAllGames();

    GamesLibrary getGameById(Long id);

    GamesLibrary createGame(GamesLibrary gamesLibrary);

    GamesLibrary updateGame(Long id, GamesLibrary gamesLibrary);

    void deleteGame(Long id);
}
