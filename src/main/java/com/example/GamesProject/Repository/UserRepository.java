package com.example.GamesProject.Repository;

import com.example.GamesProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // User Query
    User findByUsername(String username);


    User findByEmail(String email);
}