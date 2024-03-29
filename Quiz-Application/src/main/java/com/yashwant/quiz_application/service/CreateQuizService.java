package com.yashwant.quiz_application.service;

import com.yashwant.quiz_application.dtos.CreateQuizDto;
import com.yashwant.quiz_application.util.ApiResponse;
import com.yashwant.quiz_application.util.CreateQuizRequest;
import com.yashwant.quiz_application.util.PageResponse;

public interface CreateQuizService {
	
	public CreateQuizDto createQuiz(CreateQuizRequest request);
	public CreateQuizDto updateQuiz(String quizId, CreateQuizRequest request);
	public ApiResponse deleteQuiz(String quizId);
	public CreateQuizDto getQuizById(String quizId);
	public PageResponse<CreateQuizDto>getAllQuiz(int pageNumber, int pageSize, String sortBy, String sortDir);

}
