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
import com.yashwant.quiz_application.dtos.UserDto;
import com.yashwant.quiz_application.service.impl.UserServiceImpl;
import com.yashwant.quiz_application.util.ApiResponse;
import com.yashwant.quiz_application.util.PageResponse;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<UserDto>saveUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto user = userService.createUser(userDto);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
		
	}
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDto>updateUser(@Valid @RequestBody UserDto userDto, @PathVariable String userId)
	{
		UserDto user = userService.updateuser(userDto, userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<ApiResponse>deleteUser(@PathVariable String userId)
	{
		
		userService.deleteUser(userId);
		ApiResponse response = new ApiResponse();
		response.setMessage("User Deleted for given User Id : " + userId);
		response.setStatus(HttpStatus.OK);
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserDto>getUser(@PathVariable String userId)
	{
		UserDto user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	@GetMapping("/getAllUser")
	public ResponseEntity<PageResponse<UserDto>>getAllUser(@RequestParam(value = "pageNumber", defaultValue = "0", required = false)int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "2", required = false)int pageSize,
			@RequestParam(value = "sortBy",defaultValue = "userName",required = false)String sortBy,
			@RequestParam(value = "sortDir",defaultValue = "asc", required = false)String sortDir)
	{
		PageResponse<UserDto>response = userService.getAllUsers(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<UserDto>getUserByEmail(@PathVariable String email)
	{
		UserDto user = userService.getUserByEmail(email);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	@GetMapping("/getUserByName/{userName}")
	public ResponseEntity<PageResponse<UserDto>>getUserByName(@PathVariable String userName,
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false)int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "2",required = false)int pageSize,
			@RequestParam(value = "sortBy",defaultValue = "userName",required = false)String sortBy,
			@RequestParam(value = "sortDir",defaultValue = "asc",required = false)String sortDir)
	{
		PageResponse<UserDto>response = userService.getUserByName(userName, pageNumber, 
				pageSize, sortBy, sortDir );
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	

}