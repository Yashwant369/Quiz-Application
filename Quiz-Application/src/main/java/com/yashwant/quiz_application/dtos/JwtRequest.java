package com.yashwant.quiz_application.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtRequest {
	
	private String email;
	private String password;

}
