package com.yashwant.quiz_application.util;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GetQuizRequest {
	
	@NotBlank(message = "Please enter quizId")
	private String quizId;
	@NotBlank(message = "Please enter slot")
	private String slot;
	@NotBlank(message = "please enter class number")
	private String classNumber;

}
