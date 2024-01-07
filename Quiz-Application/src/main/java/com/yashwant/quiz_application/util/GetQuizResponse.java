package com.yashwant.quiz_application.util;

import java.util.List;

import lombok.Data;

@Data
public class GetQuizResponse {
	
	private String quizId;
	private String slot;
	private String classNumber;
	private Integer totalQuestion;
	private String instruction;
	private List<Quiz_Questions>questions;

}