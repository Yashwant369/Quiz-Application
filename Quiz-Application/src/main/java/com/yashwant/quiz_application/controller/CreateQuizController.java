package com.yashwant.quiz_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yashwant.quiz_application.dtos.CreateQuizDto;
import com.yashwant.quiz_application.service.impl.CreateQuizServiceImpl;
import com.yashwant.quiz_application.util.CreateQuizRequest;

@RestController
@RequestMapping("/quiz")
public class CreateQuizController {
	
	@Autowired
	private CreateQuizServiceImpl quizService;
	
	@PostMapping("/createQuiz")
	public ResponseEntity<CreateQuizDto>createQuiz(@RequestBody CreateQuizRequest request)
	{
		CreateQuizDto quiz = quizService.createQuiz(request);
		return new ResponseEntity<>(quiz, HttpStatus.OK);
		
	}
	

}
