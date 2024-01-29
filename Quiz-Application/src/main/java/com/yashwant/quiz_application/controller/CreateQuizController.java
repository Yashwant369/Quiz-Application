package com.yashwant.quiz_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yashwant.quiz_application.dtos.CreateQuizDto;
import com.yashwant.quiz_application.service.impl.CreateQuizServiceImpl;
import com.yashwant.quiz_application.util.ApiResponse;
import com.yashwant.quiz_application.util.CreateQuizRequest;
import com.yashwant.quiz_application.util.PageResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/quiz")
public class CreateQuizController {
	
	@Autowired
	private CreateQuizServiceImpl quizService;
	
	@PostMapping("/createQuiz")
	public ResponseEntity<CreateQuizDto>createQuiz(@Valid @RequestBody CreateQuizRequest request)
	{
		CreateQuizDto quiz = quizService.createQuiz(request);
		return new ResponseEntity<>(quiz, HttpStatus.OK);
		
	}
	@GetMapping("/getById/{quizId}")
	public ResponseEntity<CreateQuizDto>getbyId(@PathVariable String quizId)
	{
		CreateQuizDto quizDto = quizService.getQuizById(quizId);
		return new ResponseEntity<>(quizDto,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllQuiz")
	public ResponseEntity<PageResponse<CreateQuizDto>>getAllQuiz(@RequestParam(value = "pageNumber", defaultValue = "0", required = false)int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false)int pageSize,
			@RequestParam(value = "sortBy",defaultValue = "slot",required = false)String sortBy,
			@RequestParam(value = "sortDir",defaultValue = "asc", required = false)String sortDir)
	{
		PageResponse<CreateQuizDto>response = quizService.getAllQuiz(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteQuiz/{quizId}")
	public ResponseEntity<ApiResponse>deleteQuiz(@PathVariable String quizId)
	{
		ApiResponse response = quizService.deleteQuiz(quizId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/updateQuiz/{quizId}")
	public ResponseEntity<CreateQuizDto>updateQuiz(@Valid @RequestBody CreateQuizRequest request, @PathVariable String quizId )
	{
		CreateQuizDto quiz = quizService.updateQuiz(quizId, request);
		return new ResponseEntity<>(quiz, HttpStatus.OK);
	}

}
