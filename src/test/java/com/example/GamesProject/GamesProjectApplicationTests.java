package com.example.GamesProject;

import com.example.GamesProject.Repository.GameLibraryRepository;
import com.example.GamesProject.model.GamesLibrary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GamesProjectApplicationTests {

		@Autowired
		private GameLibraryRepository gameLibraryRepository;

		@Test
		public void testFindByTitleAndPlatform() {
			String title = "AstralChain";
			String platform = "NintendoSwitch";
			List<GamesLibrary> games = gameLibraryRepository.findByTitleAndPlatform(title, platform);
			assertNotNull(games);
		}

		@Test
		public void testFindByGenre() {
			String genre = "Action";
			List<GamesLibrary> games = gameLibraryRepository.findByGenre(genre);
			assertNotNull(games);
		}

	}


