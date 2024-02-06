

Task Management System
Description
The Task Management System is a Java Spring Boot application designed to manage tasks with different statuses (Pending, Completed, Canceled). It provides endpoints for creating, updating, deleting, and retrieving tasks based on their status.

Features
Create a new task
View all tasks
View a single task by ID
Update the status of a task (Pending, Completed, Canceled)
Retrieve tasks based on their status
Delete a task by ID

Technologies Used
Java
Spring Boot
Spring Data JPA
H2 Database (for local development)
Maven (for dependency management)
Postman (for testing endpoints)

Setup
Clone the repository:

bash
Copy code
git clone <repository_url>
Navigate to the project directory:

bash
Copy code
cd task-management-system
Build the project using Maven:

bash
Copy code
mvn clean install
Run the application:

bash
Copy code
java -jar target/task-management-system.jar
The application will start running on http://localhost:8080.
