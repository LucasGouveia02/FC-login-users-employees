# 📌 Login Microservice
This is a microservice for login on FoodConnect app and BackOffice system.

---

## 📖 Table of Contents
- [About the Project](#-about-the-project)
- [Technologies Used](#-technologies-used)
- [How to Run](#-how-to-run)
- [Available Endpoints](#-available-endpoints)
- [Request Examples](#-request-examples)
- [Security](#-security)
- [Project Structure](#-project-structure)
- [Author](#-author)

---

## 🔎 About the Project

This microservice was developed to control access in a microservices architecture.

---

## 🛠 Technologies Used

- Java 21  
- Spring Boot 3.4.3
- Spring Web
- Spring Security   
- Spring Data JPA  
- MySQL

---

## 🚀 How to Run

### Prerequisites

- Java 21
- Maven
- A configured database

### Steps

```bash
# Clone the repository
git clone https://github.com/LucasGouveia02/FC-login-users-employees.git

# Navigate into the project directory
cd FC-login-users-employees

# Run the project
./mvnw spring-boot:run
```

---

## 🔐 Available Endpoints

| Method | Endpoint       | Description                          | Authentication |
|--------|----------------|--------------------------------------|----------------|
| POST   | /CustomerLogin    | Validates credentials to grant access to FoodConnect services | ❌             |

---

## 📦 Request Examples

### Login

```http
POST /CustomerLogin
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "yourPassword123"
}
```

#### Response

```http
HTTP/1.1 200 OK
```

---

## 🔒 Security

- Passwords are validate securely using BCrypt matches.

---

## 📁 Project Structure

```css
src
├── main
│   ├── java
│   │   └── com.br.foodconnect
│   │       ├── config
|   |       ├── controller
│   │       ├── dto
│   │       ├── model
│   │       ├── repository
│   │       └── service
│   └── resources
```

---

## 👤 Authors

Made for Gabriel Santos Attuy
