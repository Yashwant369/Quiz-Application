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
- User Registration
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/36ccebaf-f79a-4db0-98fd-01ff35a453ce)

- User Login
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/f2dcab6c-a5d3-4f82-82e7-720d22c7e87a)

- Question Module(Admin has authority)

- Add Question
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/3ba0bd64-5727-468b-92a3-c2b790e7aa5f)

- Bean Validation
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/378d43b2-396a-432c-a411-0b9500bfbae8)

- Get all question
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/250949bb-2328-4b19-8978-8e5d233e485f)

  Implementation of pagination and sorting
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/c62d953b-da22-4242-9ba0-6edc6c2acb5c)

- Get Question By Id
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/d28379c5-f06f-4651-b96a-c4c0e13e2bf6)

- Get Question By Category
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/5963aede-5133-4746-afba-562752f708f0)

- Get Question By Level
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/716d476d-51c5-496a-88fc-e448a2b04c94)

- Update Question
  Implemented Customized Exception Handling
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/98e6be9b-6e85-400a-89df-7a59c39850e9)

- Delete Question
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/d46d743b-a3ad-4d7e-b6d8-c72b70003834)

- Quiz Module

- Create Quiz
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/78f9a70d-be71-415d-a9f5-fad019038c38)

- Get All Quiz
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/7f22a132-b081-4184-8328-7ef46ac25af6)

- Delete Quiz
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/bbb732c9-bfba-4b87-bf50-ad77a4a04dba)

- Update Quiz
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/b7243dd0-34b5-4cfa-b351-007bf4dbdec7)

- Get Quiz(User has Authority)
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/da226b86-ce01-4631-a2e3-1e36f8dec7d6)

- Attempt Quiz(User has Authority)
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/fc4c0a1b-4598-4d6f-b806-f045173d63cb)

- Get Report(User and Admin has Authority)
  ![image](https://github.com/Yashwant369/Quiz-Application/assets/71956889/65e4a60a-9acb-4cdd-bf74-e3e51e84239b)

**Made by [Yashwant369](https://github.com/Yashwant369)**
