# Premier League Management System

## 📌 Project Overview

The **Premier League Management System** is a **Spring Boot REST API application** designed to manage football league data such as players and teams using a layered backend architecture.
The project helps manage teams, players, matches, and the league points table using Object-Oriented Programming concepts.


---

## 🛠️ Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* REST APIs
* MySQL
* Maven
* Object-Oriented Programming (OOP)

---

## ✨ Features

* RESTful APIs for managing **players** in the Premier League
* CRUD operations (Create, Read, Update, Delete)
* Layered architecture: Controller → Service → Repository
* Global exception handling using `@ControllerAdvice.`
* JSON-based request and response handling
* Add, update, delete, and view **teams**
* Add and manage **players** for each team
* Create and manage **match results**
* Automatically calculate **points table**

  * Win → 3 points
  * Draw → 1 point
  * Loss → 0 points
* Display **league standings** based on points
* Menu-driven and user-friendly console interface

---

## 🧠 Concepts Used

* Classes and Objects
* Inheritance and Encapsulation
* Data abstraction
* Collections framework
* Conditional statements and loops

---

## ▶️ How to Run the Project

1. Make sure Java and Maven are installed
2. Configure database details in `application.properties`.
3. Run the application using:

   ```bash
   mvn spring-boot:run
   ```
4. Test APIs using **Postman** or browser
5. Clone the repository:

   ```bash
   git clone <your-github-repo-link>
   ```
6. Open the project in any Java IDE (IntelliJ IDEA / Eclipse / VS Code)
7. Compile and run the main Java file
8. Follow the on-screen menu options

---

## 📂 Project Structure

```
src/main/java/com/pl/premier_zone
│── PremierZoneApplication.java
│── player
│   │── Player.java
│   │── PlayerController.java
│   │── PlayerService.java
│   │── PlayerRepository.java
│── exception
│   │── GlobalExceptionHandler.java
```

PremierLeagueSystem
│── Team.java
│── Player.java
│── Match.java
│── LeagueManager.java
│── Main.java

```

---

## 🚀 Future Enhancements
- Implement pagination and sorting
- Add Swagger API documentation
- Secure APIs using Spring Security & JWT
- Add match statistics and goal tracking
- Create a simple **web interface**

---

## 👤 Author
**Rohit Biswas**  
B.Tech CSE Student  
GitHub: https://github.com/ROHiT7002

---

## 📄 License
This project is created for **learning and academic purposes**.

```
