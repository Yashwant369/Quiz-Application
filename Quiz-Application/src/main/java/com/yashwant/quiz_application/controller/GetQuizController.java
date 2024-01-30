package com.yashwant.quiz_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yashwant.quiz_application.service.impl.GetQuizServiceImpl;
import com.yashwant.quiz_application.util.GetQuizRequest;
import com.yashwant.quiz_application.util.GetQuizResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/getQuiz")
public class GetQuizController {
	
	@Autowired
	private GetQuizServiceImpl getQuizService;
	
	@GetMapping("/")
	public ResponseEntity<GetQuizResponse>getQuiz(@Valid @RequestBody GetQuizRequest request)
	{
		GetQuizResponse response = getQuizService.getQuiz(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
