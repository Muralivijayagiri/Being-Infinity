# Being-Infinity

A small Spring Boot 4 REST application for managing users, with a static HTML/JavaScript frontend. Users are stored in memory, so the list resets to the two seeded users on every restart.

## Requirements

- Java 17 or newer
- No separate Maven install; the Maven wrapper is included

## Run

Windows (PowerShell):

```powershell
.\mvnw.cmd spring-boot:run
```

macOS/Linux:

```bash
./mvnw spring-boot:run
```

The app starts at <http://localhost:8080>.

- Frontend: <http://localhost:8080/>
- Swagger UI: <http://localhost:8080/swagger-ui.html>
- Health check: <http://localhost:8080/actuator/health>

## Test

```powershell
.\mvnw.cmd test
```

Run a single test class:

```powershell
.\mvnw.cmd -Dtest=UserServiceTest test
```

## API

Base path: `/api/users`

| Method | Path | Description |
| --- | --- | --- |
| GET | `/api/users` | List all users |
| GET | `/api/users/{id}` | Get one user |
| GET | `/api/users/random` | Get a random user |
| POST | `/api/users` | Add a user (the id is assigned) |
| PUT | `/api/users/{id}` | Update a user |
| DELETE | `/api/users/{id}` | Delete a user |

Example request:

```json
{
  "name": "Alex Doe",
  "gender": "Other",
  "image": "/images/john.png"
}
```

## Docker

```powershell
docker build -t being-infinity .
docker run --rm -p 8080:8080 being-infinity
```

The container image builds with Maven (tests skipped) and runs the packaged JAR as a non-root user.

## Project layout

- `src/main/java/com/being_infinity/springboot_beginner_cohort_3` - application, controller, service, and model
- `src/main/resources/static` - frontend pages, JavaScript, CSS, and images
- `src/test/java` - Spring context and `UserService` tests
