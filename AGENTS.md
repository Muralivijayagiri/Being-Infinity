# AGENTS.md

## Project

Single-module Spring Boot 4.0.7 app (Java 17, Maven wrapper). `UserService` stores users in an in-memory `ArrayList` seeded with two users, so data resets on every restart. The frontend is plain HTML/JS/CSS under `src/main/resources/static` with no build step.

## Commands (PowerShell)

- Run: `.\mvnw.cmd spring-boot:run` (bash: `./mvnw spring-boot:run`)
- All tests: `.\mvnw.cmd test`
- Single test class: `.\mvnw.cmd -Dtest=UserServiceTest test`
- Compile: `.\mvnw.cmd -DskipTests compile`
- Package: `.\mvnw.cmd clean package`
- Docker: `docker build -t being-infinity .`

## Layout and wiring

- Root package: `com.being_infinity.springboot_beginner_cohort_3` (directories match the package).
- Entrypoint: `SpringbootBeginnerCohort3Application`.
- REST API under `/api/users`: GET list, GET `/{id}`, GET `/random`, POST, PUT `/{id}`, DELETE `/{id}`. POST assigns IDs starting at 3; the ID counter is not reused after deletion.
- Swagger UI: `/swagger-ui.html`; OpenAPI JSON: `/v3/api-docs`.
- Health: `/actuator/health` (spring-boot-starter-actuator is a dependency, so the Docker healthcheck works).
- Tests: a `@SpringBootTest` context smoke test and `UserServiceTest` (five unit tests for CRUD/random behavior).

## Gotchas

- This project uses Spring Boot 4's `spring-boot-starter-webmvc` and `spring-boot-starter-webmvc-test` starters; keep using these rather than the older `spring-boot-starter-web` names.
- The "Random User" page calls the external `https://randomuser.me/api`; the local `/api/users/random` flow needs no network.
- `target/` is generated and gitignored. Do not edit or commit it.
- `HELP.md` is untracked/gitignored and stale; use `README.md` instead.
