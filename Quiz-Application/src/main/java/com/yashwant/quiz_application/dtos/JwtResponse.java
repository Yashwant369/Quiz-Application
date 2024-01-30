package com.yashwant.quiz_application.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {
	
	private String jwtToken;
	private UserDto user;

}