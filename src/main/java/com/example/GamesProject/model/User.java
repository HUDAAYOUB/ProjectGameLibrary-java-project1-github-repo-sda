package com.example.GamesProject.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//*********** Table For Users *********
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @OneToMany // ********** Relation
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"user"}, allowSetters = true)
    private List<GamesLibrary> gamesLibrary;

    public User() {
    }

    public User(Long id, String username, String email, String password, List<GamesLibrary> gamesLibrary) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.gamesLibrary = gamesLibrary;
    }

    public List<GamesLibrary> getGamesLibrary() {
        return gamesLibrary;
    }

    public void setGamesLibrary(List<GamesLibrary> gamesLibrary) {
        this.gamesLibrary = gamesLibrary;
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


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gamesLibrary=" + gamesLibrary +
                '}';
    }
}
