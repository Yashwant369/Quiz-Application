package com.yashwant.quiz_application.service;

import com.yashwant.quiz_application.util.GetQuizRequest;
import com.yashwant.quiz_application.util.GetQuizResponse;

public interface GetQuizService {
	
	public GetQuizResponse getQuiz(GetQuizRequest request);

}
