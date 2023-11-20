
# Game Library Code Project 🎮

## Presentation

**Java Spring Boot**

This repository contains a game library code project built with Java and Spring Boot. The project is designed to manage and organize information about video games, including details such as title, platform, genre, release year, and user reviews. It also allows users to interact with the library by adding, updating, and deleting games.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [Code Structure](#code-structure)
- [Usage](#usage)
- [UML](#uml)
- [Configuration](#configuration)
- [Contact](#contact)
- [Resources](#resources)

## Overview

This game library code project is built using Java and Spring Boot, providing a RESTful API for managing video game information. It allows users to create, read, update, and delete game entries, as well as search for games by various criteria like title and genre. The project also includes user management, where users can create accounts and associate games with their profiles.

## Features

- **Game Management:** Users can add, update, and delete game entries. Game details include title, platform, genre, release year, status, rating, developers, play mode, and designer.

- **User Management:** Users can create accounts, and each user can have their own library of games.

- **Search Functionality:** Users can search for games by title, platform, and genre.

## Getting Started

To get started with this project, you will need to have Java and Spring Boot set up on your local development environment. Follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/HUDAAYOUB/ProjectGameLibrary.git
   cd ProjectGameLibrary
   ```

## Code Structure

### Controllers:

#### 1. GameLibraryController.java



**Description:** Manages endpoints related to game operations.

#### 2. UserController.java



**Description:** Handles user-related endpoints.

### Models:

#### 1. User


**Description:** Represents a user in the database.

**Fields:**
- `id`: Unique identifier for the user (auto-generated).
- `username`: Username used for login.
- `email`: User's email address.
- `password`: Password used for login.
- `name`: Name of the user.
- `userGames`: List of user games associated with the user.
- `roles`: Collection of roles assigned to the user.

**Constructors:**
- Default constructor.
- Parameterized constructor.

**Methods:**
- `removeUserGame(Long gameId)`: Removes a game from the user's library.
- `addUserGame(Long gameId)`: Adds a game to the user's library.

#### 2. Role



**Description:** Represents a user role.

**Fields:**
- `id`: Unique identifier for the role (auto-generated).
- `name`: Name of the role.

**Constructors:**
- Default constructor.
- Parameterized constructor.

#### 3. GameStatus

**Package:** `com.example.ProjectGameLibrary.model`

**Description:** Enumeration representing the status of the game interaction (`NOT_STARTED`, `PLAYING`, `PLAYED`).

#### 4. UserGame



**Fields:**
- `id`: Unique identifier for the user game (auto-generated).
- `user`: Reference to the associated user.
- `game`: Reference to the associated game from the game library.
- `userRating`: User's rating for the game.
- `userOpinion`: User's opinion about the game.
- `status`: Enumeration representing the status of the game interaction (`NOT_STARTED`, `PLAYING`, `PLAYED`).

**Constructors:**
- Default constructor.
- Parameterized constructor.

**Methods:**
- Getters and setters for all fields.

#### 5. GamesLibrary



**Fields:**
- `id`: Unique identifier for the game (auto-generated).
- `title`: Title of the game.
- `platform`: Platform on which the game is available.
- `genre`: Genre of the game.
- `releaseYear`: Release year of the game.
- `status`: Enumeration representing the status of the game (`NOT_STARTED`, `PLAYING`, `PLAYED`).
- `rating`: Rating of the game.

**Constructors:**
- Default constructor.
- Parameterized constructor.

**Methods:**
- Getters and setters for all fields.

### Repository:

#### 1. GameLibraryRepository.java


**Description:** Provides data access methods for the GamesLibrary entity.

#### 2. UserRepository.java

**Description:** Offers data access methods for the User entity.

### Service:

#### 1. GameLibraryService.java

**Package:** `com.example.ProjectGameLibrary.service`

**Description:** Contains business logic for game-related operations.

#### 2. UserService.java

**Package:** `com.example.ProjectGameLibrary.service`

**Description:** Implements business logic for user-related operations.

### Resources:

- **application.properties:** Configuration file for setting up the database and other properties.

### Tests:

- **Unit test classes:** For controllers, repositories, and services.

### Other Project Files:

- **pom.xml:** Maven configuration file for project dependencies and build settings.
- **Other project-specific files and directories as needed.**

## Usage

To use this project, you can interact with the API endpoints through tools like Postman or by creating your own front-end application. Here are some sample API endpoints:

- **GET /games:** Retrieve a list of all games.

- **GET /games/search?title:** Search for a game by its title.

- **GET /games/search1?genre:** Search for a game by its genre.

- **GET /games/{id}:** Retrieve a specific game by its ID.

- **POST /games:** Create a new game entry.

- **PATCH /games/{id}:** Update an existing game entry.

- **DELETE /games/{id}:** Delete a game entry.

- **GET /users:** Retrieve a list of all users.

- **GET /users/{id}:** Retrieve a specific user by their ID.

- **POST /users:** Create a new user.

- **PUT /users/{id}:** Update an existing user.

- **DELETE /users/{id}:** Delete a user.

## UML

Use case | Database | Class
--- | --- | ---
**Configuration**

The project uses a PostgreSQL database, and you may need to configure the database connection details in the application.properties file. Additionally, the project includes validation constraints and error messages for input data, which you can customize if needed.

## Contact

For inquiries and support, please contact [Your Name] at [your.email@example.com].

## Resources

- [Wikipedia](https://en.wikipedia.org/)
- [Code Java](https://www.codejava.net/)
- [Java T Point](https://www.javatpoint.com/)
- [Canva](https://www.canva.com/)
- [ChatGPT](https://www.openai.com/)
```
