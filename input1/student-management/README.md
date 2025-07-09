# Student Management System

This is a Spring Boot application for managing student records. It provides a RESTful API to perform CRUD operations on student data and retrieve rankings based on marks.

## Project Structure

```
student-management
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── studentmanagement
│   │   │               ├── StudentManagementApplication.java
│   │   │               ├── controller
│   │   │               │   └── StudentController.java
│   │   │               ├── service
│   │   │               │   └── StudentService.java
│   │   │               ├── repository
│   │   │               │   └── StudentRepository.java
│   │   │               └── model
│   │   │                   └── Student.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── data.sql
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── studentmanagement
│                       └── StudentManagementApplicationTests.java
├── pom.xml
└── README.md
```

## Features

- **Create Student**: Add a new student record.
- **Get Student**: Retrieve a student by their ID.
- **Delete Student**: Remove a student record by ID.
- **Get Rank by Marks**: Retrieve a list of students ranked by their marks.

## API Endpoints

- `POST /students`: Create a new student.
- `GET /students/{id}`: Get a student by ID.
- `DELETE /students/{id}`: Delete a student by ID.
- `GET /students/rank`: Get students ranked by their marks.

## Setup Instructions

1. Clone the repository.
2. Navigate to the project directory.
3. Ensure you have Java and Maven installed.
4. Run the application using the command:
   ```
   mvn spring-boot:run
   ```
5. Access the API at `http://localhost:8080`.

## Database Initialization

The `data.sql` file can be used to initialize the database with sample data. Modify it as needed to suit your requirements.

## Testing

Unit tests are included in the `src/test` directory to ensure the application functions as expected. Run the tests using:
```
mvn test
```

## Dependencies

This project uses Maven for dependency management. The `pom.xml` file includes necessary dependencies for Spring Boot and JDBC Template.