package com.example.GamesProject.Repository;

import com.example.GamesProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);
    void deleteAllByEmail(String email);
    /**
     * Method to find a User entity by its username field
     *
     * @param username The username of the User entity to search for
     * @return The found User entity or null if not found
     */
    User findByUsername(String username);
}