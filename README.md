# FlexiSaf-weekly-deliverables
Task3/framework-architecture
All deliverables will be housed inside this repository

Task 3 – Spring Boot Application with 4 endpoints (Contact Module)
This task involved creating a Spring Boot application with at least 4 endpoints.
All endpoints were implemented inside the Contact module, following proper structure with controllers, services, and models.

The application connects to the database via the configuration in application.properties and can be run and tested using tools like Postman.

Implemented Endpoints (Contact Module)
POST /contacts – Create a new contact
GET /contacts/{firstName} – Retrieve a single contact by firstName
PUT /contacts/{firstName} – Update an existing contact
 DELETE /contacts/{firstName} – Delete a contact
 
All deliverables will be housed inside this repository and I will be updating the README file weekly stating what was done on each task.

TASK 1: This folder contains the setup work I did for Task 1.
What I Did -
- Set up a Spring Boot application using Maven as the build tool.
- Configured PostgreSQL as the database and added the DB settings inside application.properties.
- Used pgAdmin 4 as the database management/admin tool.
- Set up the basic application environment with Spring Boot’s core libraries and the default embedded server.
 main
