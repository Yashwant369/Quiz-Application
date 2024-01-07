package com.yashwant.quiz_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashwant.quiz_application.entity.CreateQuiz;

public interface CreateQuizRepo extends JpaRepository<CreateQuiz, String> {

}
