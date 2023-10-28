package com.example.GamesProject.Controller.interfaces;

import com.example.GamesProject.model.GamesLibrary;

import java.util.List;

public interface IGameLibraryInterface  {
    List<GamesLibrary> getAllGames();

    List<GamesLibrary> getGamesByTitle(String title);

    List<GamesLibrary> getGamesByGenre(String genre);
    GamesLibrary getGameById(Long id);

    GamesLibrary createGame(GamesLibrary gamesLibrary);

    GamesLibrary updateGame(Long id, GamesLibrary gamesLibrary);

    void deleteGame(Long id);
}
