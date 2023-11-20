package com.example.GamesProject.model;

import jakarta.persistence.*;

@Entity
public class UserGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GamesLibrary game;

    private int userRating;
    private String userOpinion;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    // Add a default constructor
    public UserGame() {
    }

    public UserGame(Long id, User user, GamesLibrary game, int userRating, String userOpinion, GameStatus status) {
        this.id = id;
        this.user = user;
        this.game = game;
        this.userRating = userRating;
        this.userOpinion = userOpinion;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GamesLibrary getGame() {
        return game;
    }

    public void setGame(GamesLibrary game) {
        this.game = game;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public String getUserOpinion() {
        return userOpinion;
    }

    public void setUserOpinion(String userOpinion) {
        this.userOpinion = userOpinion;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }
}