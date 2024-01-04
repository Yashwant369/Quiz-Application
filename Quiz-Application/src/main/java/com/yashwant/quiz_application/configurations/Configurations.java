package com.yashwant.quiz_application.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
	
	@Bean
	public ModelMapper getMapper()
	{
		return new ModelMapper();
	}

}
