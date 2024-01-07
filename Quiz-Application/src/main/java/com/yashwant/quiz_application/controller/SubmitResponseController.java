package com.yashwant.quiz_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yashwant.quiz_application.entity.SubmitResponse;
import com.yashwant.quiz_application.service.impl.SubmitResponseServiceImpl;
import com.yashwant.quiz_application.util.ApiResponse;

@RestController
@RequestMapping("/submitResponse")
public class SubmitResponseController {
	
	@Autowired
	private SubmitResponseServiceImpl submitResponseService;
	
	@PostMapping("/")
	public ResponseEntity<ApiResponse>submitResponse(@RequestBody SubmitResponse response)
	{
		ApiResponse response1 = submitResponseService.submitResponse(response);
		return new ResponseEntity<>(response1, HttpStatus.OK);
	}

}
