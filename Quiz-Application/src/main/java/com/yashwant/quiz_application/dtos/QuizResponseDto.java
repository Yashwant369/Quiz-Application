package com.yashwant.quiz_application.dtos;

import lombok.Data;

@Data
public class QuizResponseDto {
	

	private String quizResponseId;
	private String questionId;
	private String submitAnswer;
	private SubmitResponseDto response;

}
