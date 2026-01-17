# ⚽ Premier League Management System (Spring Boot Backend)

## 📌 Overview
The **Premier League Management System** is a **Spring Boot–based RESTful backend application** used to manage and analyze Premier League player statistics.  
It allows users to **add, update, delete, search, and filter players** using well-structured REST APIs.

This project follows **clean layered architecture** with proper **exception handling, validation, and database interaction** using Spring Data JPA.

---

## 🛠️ Tech Stack
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Maven**
- **REST APIs**
- **Jakarta Validation**
- **MySQL / H2 Database**

---

## 📂 Project Architecture
com.pl.premier_zone
│
├── controller
│ └── PlayerController
│
├── entity
│ └── Player
│
├── repository
│ └── PlayerRepository
│
├── service
│ └── PlayerService
│
├── exception
│ ├── BadRequestException
│ ├── ResourceNotFoundException
│ └── GlobalExceptionHandler
│
└── PremierZoneApplication

---

## 🚀 Features
- Add new Premier League players
- Update existing player details
- Delete players by ID
- Fetch all players
- Search players by **name (partial match)**
- Filter players by:
  - Team
  - Position
  - Nation
  - Team + Position
- Prevent duplicate player entries
- Centralized exception handling with meaningful error responses

---

## 🔗 REST API Endpoints

| HTTP Method | Endpoint | Description |
|-----------|---------|-------------|
| GET | `/api/v1/player` | Fetch all players |
| GET | `/api/v1/player/{id}` | Fetch player by ID |
| GET | `/api/v1/player?name=Ronaldo` | Search player by name |
| GET | `/api/v1/player?team=Arsenal` | Filter players by team |
| GET | `/api/v1/player?position=Forward` | Filter players by position |
| POST | `/api/v1/player` | Add new player |
| PUT | `/api/v1/player/{id}` | Update player |
| DELETE | `/api/v1/player/{id}` | Delete player |

---

## 🧪 Validation & Exception Handling
- Input validation using `@Valid` and `@NotBlank`
- Custom exceptions:
  - `ResourceNotFoundException`
  - `BadRequestException`
- Global exception handling using `@ControllerAdvice`
- Proper HTTP status codes for all responses

---

## ▶️ How to Run the Project
1. Clone the repository
   ```bash
   git clone https://github.com/ROHiT7002/Premier-League-Management-System.git
2. Open the project in IntelliJ IDEA / Eclipse
3. Configure database in application.properties
4. Run:
     PremierZoneApplication.java
6. Test APIs using Postman


## 📌 Future Improvements
- Add Team and Match modules
- Pagination and sorting
- Authentication & Authorization
- Frontend integration
