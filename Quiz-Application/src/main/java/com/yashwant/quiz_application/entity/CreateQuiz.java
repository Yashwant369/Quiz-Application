package com.yashwant.quiz_application.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class CreateQuiz {
	
	@Id
	private String quizId;
	private String slot;
	private String classNumber;
	private Date createdDate;
	private Integer easyQuestions;
	private Integer mediumQuestions;
	private Integer hardQuestions;
	private Integer totalQuestions;
	private String instructions;
	private String questionCategory;
	@ManyToMany
	List<Question>questions = new ArrayList<>();

}
