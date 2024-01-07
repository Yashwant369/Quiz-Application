package com.yashwant.quiz_application.util;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateQuizRequest {
	
	@NotBlank(message = "Please enter slot")
	private String slot;
	@NotBlank(message = "Please enter class Number")
	private String classNumber;
	@NotBlank(message = "Please enter no. of easy question")
	private Integer easyQuestions;
	@NotBlank(message ="Please enter no. of medium question")
	private Integer mediumQuestions;
	@NotBlank(message = "Please enter no. of hard question")
	private Integer hardQuestions;
	@NotBlank(message = "Please enter category" )
	private String questionCategory;
	private String instructions;

}
