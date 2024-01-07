package com.yashwant.quiz_application.service;

import com.yashwant.quiz_application.dtos.UserDto;
import com.yashwant.quiz_application.util.PageResponse;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	UserDto updateuser(UserDto userDto, String userId);
	void deleteUser(String userId);
	PageResponse<UserDto>getAllUsers(int pageNumber, int pageSize, String sortBy, String sortDir);
	UserDto getUserById(String userId);
	UserDto getUserByEmail(String email);
	PageResponse<UserDto>getUserByName(String name, int pageNumber, int pageSize, String sortBy, String sortDir);

}
