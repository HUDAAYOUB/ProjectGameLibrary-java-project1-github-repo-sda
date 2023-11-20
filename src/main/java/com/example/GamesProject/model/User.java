package com.example.GamesProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

/**
 * Entity class for representing a User in the database
 */
@Entity
public class User {
    /**
     * The unique identifier for the user
     */
    @Id
    /**
     * The id field is generated automatically by the database
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The username used to log in
     */
    private String username;
    private String email;

    /**
     * The password used to log in
     */
    private String password;
    /**
     * The name of the user
     */
private String name;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("user")
    private List<UserGame> userGame;
    /**
     * The roles that the user has
     */
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    // Constructors, getters, setters, and other methods

    public User() {}
    public void removeUserGame(Long gameId) {
        if (userGame != null) {
            userGame.removeIf(userGame -> userGame.getGame().getId().equals(gameId));
        }
    }

    public User(Long id, String username, String email, String password, String name, List<UserGame> userGame, Collection<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.userGame = userGame;
        this.roles = roles;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
// Getters, setters, constructors, toString, etc.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserGame> getUserGame() {
        return userGame;
    }

    public void setUserGame(List<UserGame> userGame) {
        this.userGame = userGame;
    }

    public void addUserGame(Long gameId) {

    }


}