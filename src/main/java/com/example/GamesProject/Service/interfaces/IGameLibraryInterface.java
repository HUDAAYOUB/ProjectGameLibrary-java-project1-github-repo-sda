package com.example.GamesProject.Service.interfaces;

import com.example.GamesProject.model.GamesLibrary;

import java.util.List;

public interface IGameLibraryInterface {

    GamesLibrary createGame(GamesLibrary newGame);

    List<GamesLibrary> getGamesByTitle(String title);

    List<GamesLibrary> getGamesByGenre(String genre);
}
