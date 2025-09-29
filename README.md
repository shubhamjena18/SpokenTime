# Spoken Time Service

A Java-based application that converts time input into its **British spoken form** (e.g., '12:00' → 'noon'). 
## Features

- Convert 24-hour time format into British spoken words.
- Handles special times like `noon` and `midnight`.
- Uses Redis for caching frequent time conversions.
- Modular design using common design patterns for clean code.

## Technologies Used

- **Java** 21
- **Spring Boot**
- **Redis** (as cache)
- **Maven** (for dependency management)
- **Docker** (containerized deployment)

## Architecture & Design Patterns

- **Singleton** – for Redis cache configuration.
- **Factory / Strategy** – for time-to-word conversion logic.
- **Caching** – Redis is used to store previously computed results to reduce computation time.

## Prerequisites

- Java 21
- Maven installed
- Docker & Docker Compose (optional, for running Redis and the service together)

## Running Locally

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <project-folder>

## Running with Docker

Make sure Docker and Docker Compose are installed.

Run the project and Redis using Docker Compose:

docker-compose up --build
