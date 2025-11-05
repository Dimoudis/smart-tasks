# smart-tasks
A Spring Boot project demonstrating basic CRUD operations with Tasks using JPA and a database. Supports GET, POST, PUT, DELETE.

# Smart Tasks

A Spring Boot project demonstrating basic CRUD operations with Tasks using JPA and a database.

## Features

- Create a new task (POST /tasks)
- Get all tasks (GET /tasks)
- Update a task by ID (PUT /tasks/{id})
- Delete a task by ID (DELETE /tasks/{id})
- Uses H2 database for persistence
- IDs are auto-incremented and unique

## Running the project

1. Clone the repository
2. Run the Spring Boot application
3. Use Postman or your browser to test CRUD operations:
   - GET /tasks
   - POST /tasks
   - PUT /tasks/{id}
   - DELETE /tasks/{id}

## Notes

- The H2 console is available at `/h2-console` (username: sa, password empty)
- Data persists between server restarts using a file-based H2 database
