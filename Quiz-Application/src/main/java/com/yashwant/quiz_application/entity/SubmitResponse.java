package com.yashwant.quiz_application.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class SubmitResponse {
	
	@Id  
	private String responseId;
	private String userId;
	private String userName;
	private String quizId;
	private String slot;
	private String classNumber;
	@OneToMany(mappedBy = "response", cascade = CascadeType.ALL)
	private List<QuizResponse>responses;

}
