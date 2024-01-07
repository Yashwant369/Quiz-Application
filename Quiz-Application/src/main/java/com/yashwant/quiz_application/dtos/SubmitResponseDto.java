package com.yashwant.quiz_application.dtos;

import java.util.List;

import lombok.Data;

@Data
public class SubmitResponseDto {
	
	private String responseId;
	private String userId;
	private String userName;
	private String quizId;
	private String slot;
	private String classNumber;
	private List<QuizResponseDto>responses;

}
