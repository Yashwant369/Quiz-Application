# Quiz Application

## Project Description
Quiz Application is a REST API designed for creating and managing quizzes. Admins can create quizzes with questions, users can attempt these quizzes, and both admins and users can view scores. The project comprises several modules including Question, Quiz, Quiz Question, Attempt, and Score. Additionally, features such as pagination, sorting, API validation using bean validator, and global exception handling have been implemented.

## Tech Stack
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- MySQL
- Spring Security

## Modules

### Question Module
- **Admin Privileges:** CRUD operations for managing quiz questions.

### Quiz Module
- **Admin Privileges:** Creation of quizzes based on slot and class number.

### Quiz Question Module
- **User Privileges:** Fetching questions based on slot and class ID.

### Attempt Module
- **User Privileges:** Attempting quiz questions and submitting responses.

### Score Module
- **Admin and User Privileges:** Viewing quiz scores.

## Functionality Implemented
- Pagination and Sorting: Data displayed in paginated form and can be sorted.
- API Validation: Input validation using bean validator.
- Global Exception Handling: Handling exceptions throughout the project.
- Role-Based Authentication: Admins and users have different levels of access.

## Working of Project
- Admins create quizzes with questions.
- Users attempt quizzes and submit responses.
- Scores are calculated and can be viewed by both admins and users.

## Database Mapping
- Question-Quiz mapping: One quiz can have multiple questions.
- Quiz-Quiz Question mapping: One quiz can have multiple quiz questions.
- User-Attempt mapping: Each user can have multiple attempts.
- Quiz-Attempt mapping: Each attempt is associated with a quiz.

## Screenshot
[Add screenshot here]



**Made by [Yashwant369](https://github.com/Yashwant369)**
