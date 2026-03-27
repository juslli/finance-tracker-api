# Finance Tracker API

RESTful API for personal finance tracking built with Java and Spring Boot.

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database (in-memory)
- Bean Validation
- Maven

## Features
- User CRUD with full validation
- Standardized error responses
- Custom exception handling
- API versioning (/api/v1)

## Running locally
```bash
./mvnw spring-boot:run
```

API available at: `http://localhost:8080`

## Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/v1/users | Create user |
| GET | /api/v1/users | List all users |
| GET | /api/v1/users/{id} | Get user by id |
| PUT | /api/v1/users/{id} | Update user |
| DELETE | /api/v1/users/{id} | Delete user |
| GET | /health | Health check |
