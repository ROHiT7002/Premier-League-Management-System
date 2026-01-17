Premier League Management System (Backend)
📌 Project Description

The Premier League Management System is a Spring Boot–based RESTful backend application designed to manage and analyze Premier League player statistics.
It provides APIs to add, update, delete, search, and filter players based on team, position, nationality, and other performance metrics.

This project follows a layered architecture (Controller, Service, Repository) with proper exception handling and validation.

🛠️ Technologies Used

Java

Spring Boot

Spring Data JPA

Hibernate

Maven

REST API

MySQL

Jakarta Validation

<hr>

📂 Project Structure
com.pl.premier_zone
│
├── controller
│   └── PlayerController
│
├── entity
│   └── Player
│
├── repository
│   └── PlayerRepository
│
├── service
│   └── PlayerService
│
├── exception
│   ├── BadRequestException
│   ├── ResourceNotFoundException
│   └── GlobalExceptionHandler
│
└── PremierZoneApplication


🚀 Features

Add new Premier League players

Update existing player details

Delete players by ID

Fetch all players

Search players by name (partial match supported)

Filter players by:

Team

Position

Nation

Team + Position

Prevent duplicate players (same name, team, and age)

Centralized exception handling with meaningful error messages
