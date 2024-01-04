package com.yashwant.quiz_application.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yashwant.quiz_application.entity.Question;

public interface QuestionRepo extends JpaRepository<Question, String>{

	Page<Question> findByCategory(String category, Pageable pageable);

	Page<Question> findByDifficultLevel(String level, Pageable pageable);

}
