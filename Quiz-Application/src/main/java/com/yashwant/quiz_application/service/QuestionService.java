package com.yashwant.quiz_application.service;

import com.yashwant.quiz_application.dtos.QuestionDto;
import com.yashwant.quiz_application.util.ApiResponse;
import com.yashwant.quiz_application.util.PageResponse;

public interface QuestionService {
	
	public QuestionDto createQuestion(QuestionDto questionDto);
	public QuestionDto updateQuestion(String questionId, QuestionDto questionDto);
	public ApiResponse deleteQuestion(String questionId);
	public QuestionDto getQuestionById(String questionId);
	public PageResponse<QuestionDto>getAllQuestion(int pageNumber, int pageSize, String sortBy, String sortDir);
	public PageResponse<QuestionDto>getQuestionByCategory(String category,
			int pageNumber, int pageSize, String sortBy, String sortDir);
	public PageResponse<QuestionDto>getQuestionByLevel(String level, 
			int pageNumber, int pageSize, String sortBy, String sortDir);

}
