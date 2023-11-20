package com.example.GamesProject.Service.impl;

import com.example.GamesProject.Controller.interfaces.IUserInterface;
import com.example.GamesProject.Repository.GameLibraryRepository;
import com.example.GamesProject.Repository.RoleRepository;
import com.example.GamesProject.Repository.UserGameRepository;
import com.example.GamesProject.Repository.UserRepository;
import com.example.GamesProject.Service.interfaces.IUserService;
import com.example.GamesProject.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Slf4j
public class UserService implements IUserService, UserDetailsService {

    /**
     * Autowired UserRepository for database operations.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Autowired RoleRepository for database operations.
     */
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Injects a bean of type PasswordEncoder into this class.
     * The bean is used for encoding passwords before storing them.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    GameLibraryRepository gameLibraryRepository;

    @Autowired
    UserGameRepository userGameRepository;

     //  ********** Get all Users + Find User ByID
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + id + " not found");
        }
    }

    public User addGameToUser(Long userId, Long gameId, int userRating, String userOpinion, GameStatus status) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + userId + " not found"));

        GamesLibrary game = gameLibraryRepository.findById(gameId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found"));

        // Assuming User has a method like addUserGame(Long gameId) to add games to the user
        UserGame newUserGame = new UserGame();
        newUserGame.setUser(user);
        newUserGame.setGame(game);
        newUserGame.setUserRating(userRating);
        newUserGame.setUserOpinion(userOpinion);
        newUserGame.setStatus(status);
        userGameRepository.save(newUserGame);

        //user.addUserGame(gameId);
        User userUpdated = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + userId + " not found"));

        return userUpdated;
    }


    // ********** Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // ********** Update user info
    public User updateUser(Long id, User user) {
        User updateUser = userRepository.findById(id).orElse(null);
        if (updateUser != null) {
            updateUser.setUsername(user.getUsername());
            updateUser.setEmail(user.getEmail());
            updateUser.setPassword(user.getPassword());
            return userRepository.save(updateUser);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + id + " not found");
        }
    }

    // ********** Delete User
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }





    /**
     * Loads the user by its username
     *
     * @param username the username to search for
     * @return the UserDetails object that matches the given username
     * @throws UsernameNotFoundException if the user with the given username is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve user with the given username
        User user = userRepository.findByUsername(username);
        // Check if user exists
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
            // Create a collection of SimpleGrantedAuthority objects from the user's roles
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            // Return the user details, including the username, password, and authorities
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }

    /**
     * Saves a new user to the database
     *
     * @param user the user to be saved
     * @return the saved user
     */
    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        // Encode the user's password for security before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Saves a new role to the database
     *
     * @param role the role to be saved
     * @return the saved role
     */
    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    /**
     * Adds a role to the user with the given username
     *
     * @param username the username of the user to add the role to
     * @param roleName the name of the role to be added
     */
    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);

        // Retrieve the user and role objects from the repository
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);

        // Add the role to the user's role collection
        user.getRoles().add(role);

        // Save the user to persist the changes
        userRepository.save(user);
    }

    /**
     * Retrieves the user with the given username
     *
     * @param username the username to search for
     * @return the user with the given username
     */
    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    /**
     * Retrieves all users from the database
     *
     * @return a list of all users
     */
    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
