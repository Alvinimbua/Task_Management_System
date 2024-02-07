

# Task Management System
## Description
The Task Management System is a Java Spring Boot application designed to manage tasks with different statuses (Pending, Completed, Canceled). It provides endpoints for creating, updating, deleting, and retrieving tasks based on their status.

## Features
- Create a new task
- View all tasks
- View a single task by ID
- Update the status of a task (Pending, Completed, Canceled)
- Retrieve tasks based on their status
- Delete a task by ID

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- H2 Database (for local development)
- Maven (for dependency management)
- Postman (for testing endpoints)
- Swagger-Ui for ADI Documentation

## Setup
Clone the repository:

Copy code
```zsh
git clone <repository_url>
```
Navigate to the project directory:


Copy code
```zsh
cd task-management-system
```
Build the project using Maven:


Copy code
```zsh
mvn clean install
```
Run the application:


Copy code
```zsh
java -jar target/task-management-system.jar
```
The application will start running on http://localhost:8080.

## Author
Alvin Imbuka

## License
[MIT](https://choosealicense.com/licenses/mit/)
