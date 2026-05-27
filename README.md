# Real-Time Chat API

A real-time chat backend built with Spring Boot, JWT authentication, PostgreSQL, and WebSockets.

## Features

- User registration and login
- JWT access and refresh tokens
- Protected REST endpoints
- Chat room creation and listing
- Message history
- Real-time messaging with WebSocket/STOMP
- PostgreSQL persistence
- Swagger/OpenAPI documentation

## Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT
- Spring WebSocket
- STOMP
- PostgreSQL
- JPA/Hibernate
- Maven

## Architecture

REST is used for authentication, rooms, and message history.

WebSocket is used for live messages.

```text
Client
↓
REST: /auth/login, /api/rooms
↓
WebSocket: /ws
↓
STOMP send: /app/rooms/{roomId}/send
↓
STOMP subscribe: /topic/rooms/{roomId}