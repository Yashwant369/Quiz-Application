package com.yashwant.quiz_application.util;

import java.util.List;

import lombok.Data;

@Data
public class GetReportResponse {
	
	private String userName;
	private String userId;
	private String userEmail;
	private String quizId;
	private String slot;
	private String classNumber;
	private Integer totalMarks;
	private List<Question_Response>responses;
	

}
