package com.example.GamesProject.Repository;

import com.example.GamesProject.model.GamesLibrary;
import com.example.GamesProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GameLibraryRepository extends JpaRepository<GamesLibrary, Long> {
    List<GamesLibrary> findByUser(User user);
    List<GamesLibrary> findByTitleAndPlatform(String title, String platform);
    List<GamesLibrary> findByGenre(String genre);

    List<GamesLibrary> findByStatus(String status);
}