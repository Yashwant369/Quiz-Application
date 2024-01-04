package com.yashwant.quiz_application.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuestionDto {
	
	private String questionId;
	@NotBlank(message = "Please enter question title")
	private String questionTitle;
	@NotBlank(message = "Please enter atleast two choices")
	private String option1;
	@NotBlank(message = "Please enter atleast two choices")
	private String option2;
	private String option3;
	private String option4;
	@NotBlank(message = "Please enter right answer")
	private String rightAnswer;
	@NotBlank(message = "Please enter difficult level")
	private String difficultLevel;
	@NotBlank(message = "Please enter category")
	private String category;

}
