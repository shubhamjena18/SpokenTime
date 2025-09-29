# 🕒 Spoken Time API

A **Spring Boot REST API** that converts digital time into **natural spoken English**.  

---

## ✨ Features

- Convert 24-hour digital time into spoken English phrases  
- Special case handling: **midnight** and **noon**  
- Common expressions like **“quarter past”**, **“half past”**, **“quarter to”**  
- Redis integration for caching  
- Configurable via `application.yml`  
- REST API + Docker support  

---

## 🛠️ Tech Stack

- **Java 21**  
- **Spring Boot**  
- **Spring Web** (REST API)  
- **Redis** (for caching)  
- **Maven** (build tool)  
- **Docker & Docker Compose**  

---


---

## 🚀 Getting Started

### Prerequisites
- Docker and Docker Compose installed  
- (Optional) Java 21 and Maven if running outside Docker  

---

### 🔹 Run with Docker Compose

Build and start the services (Redis + API):

```bash
docker-compose up --build


