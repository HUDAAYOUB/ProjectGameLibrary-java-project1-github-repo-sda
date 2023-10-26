# Game Library Code Project

![Java](https://img.shields.io/badge/Java-11-green)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5-blue)

This repository contains a game library code project built with Java and Spring Boot. The project is designed to manage and organize information about video games, including details such as title, platform, genre, release year, and user reviews. It also allows users to interact with the library by adding, updating, and deleting games.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [Code Structure](#code-structure)  <!-- Corrected anchor link -->
- [Usage](#usage)
- [UML](#uml)  <!-- Corrected anchor link -->
- [Configuration](#configuration)
- [Contact](#contact)


## Overview

This game library code project is built using Java and Spring Boot, and it provides a RESTful API for managing video game information. It allows users to create, read, update, and delete game entries, as well as search for games by various criteria like title and genre. The project also includes user management, where users can create accounts and associate games with their profiles.

## Features
- **Game Management:** The project allows users to add, update, and delete game entries. Game details include title, platform, genre, release year, status, rating, developers, play mode, and designer.

- **User Management:** Users can create accounts, and each user can have their own library of games.

- **Search Functionality:** Users can search for games by title, platform, and genre.

## Getting Started

To get started with this project, you will need to have Java and Spring Boot set up on your local development environment. You can follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/your-game-library.git](https://github.com/HUDAAYOUB/ProjectGameLibrary.git)https://github.com/HUDAAYOUB/ProjectGameLibrary.git
   cd your-game-library

## Code Structure
**Controllers:**

GameLibraryController.java: Manages endpoints related to game operations.
UserController.java: Handles user-related endpoints.
**Model:**

GamesLibrary.java: Represents the game entity with attributes like title, platform, genre, and more.
User.java: Represents user information including username, email, and password.

**Repository:**

GameLibraryRepository.java: Provides data access methods for the GamesLibrary entity.
UserRepository.java: Offers data access methods for the User entity.
**Service:**

GameLibraryService.java: Contains business logic for game-related operations.
UserService.java: Implements business logic for user-related operations.
**Resources:**

application.properties: Configuration file for setting up the database and other properties.
**Tests:**

Unit test classes for controllers, repositories, and services.
Other Project Files:


**pom.xml:** Maven configuration file for project dependencies and build settings.
Other project-specific files and directories as needed.

## Usage

To use this project, you can interact with the API endpoints through tools like Postman or by creating your own front-end application. Here are some sample API endpoints:

GET /games: Retrieve a list of all games.

GET /games/{id}: Retrieve a specific game by its ID.

POST /games: Create a new game entry.

PATCH /games/{id}: Update an existing game entry.

DELETE /games/{id}: Delete a game entry.

GET /users: Retrieve a list of all users.

GET /users/{id}: Retrieve a specific user by their ID.

POST /users: Create a new user.

PUT /users/{id}: Update an existing user.

DELETE /users/{id}: Delete a user.
## UML
[![Image Alt Text](https://github.com/HUDAAYOUB/ProjectGameLibrary/raw/main/11.png)](https://github.com/HUDAAYOUB/ProjectGameLibrary/blob/main/11.png)
[![Image Alt Text](https://github.com/HUDAAYOUB/ProjectGameLibrary/raw/main/12.png)](https://github.com/HUDAAYOUB/ProjectGameLibrary/blob/main/12.png)

## Configuration
The project uses a PostgreSQL database, and you may need to configure the database connection details in the application.properties file. Additionally, the project includes validation constraints and error messages for input data, which you can customize if needed.
