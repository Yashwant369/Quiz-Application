package com.yashwant.quiz_application.util;

import lombok.Data;

@Data
public class GetQuizRequest {
	
	private String quizId;
	private String slot;
	private String classNumber;

}
