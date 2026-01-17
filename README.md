
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
