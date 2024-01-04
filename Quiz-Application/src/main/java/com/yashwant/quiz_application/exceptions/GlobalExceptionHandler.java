package com.yashwant.quiz_application.exceptions;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.yashwant.quiz_application.util.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse>handlerResource(ResourceNotFoundException ex)
	{
		ApiResponse response = new ApiResponse();
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setSuccess(false);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<HashMap<String,String>>handlerMethodArgument(MethodArgumentNotValidException ex)
	{
		HashMap<String,String>map = new HashMap<>();
		List<ObjectError>list = ex.getBindingResult().getAllErrors();
		for(ObjectError error : list)
		{
			String message = error.getDefaultMessage();
			String field = ((FieldError)error).getField();
			map.put(field, message);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}

}
