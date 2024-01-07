package com.yashwant.quiz_application.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yashwant.quiz_application.entity.Question;

import lombok.Data;

@Data
public class CreateQuizDto {
	
	private String quizId;
	private String slot;
	private String classNumber;
	private Date createdDate;
	private Integer easyQuestions;
	private Integer mediumQuestions;
	private Integer hardQuestions;
	private Integer totalQuestions;
	private String questionCategory;
	private String instructions;
	List<Question>questions = new ArrayList<>();

}
