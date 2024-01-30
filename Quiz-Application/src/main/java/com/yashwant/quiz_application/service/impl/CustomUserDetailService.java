package com.yashwant.quiz_application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yashwant.quiz_application.entity.User;
import com.yashwant.quiz_application.exceptions.ResourceNotFoundException;
import com.yashwant.quiz_application.repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.getUserByEmail(username);
		if(user == null)
		{
			throw new ResourceNotFoundException("User not found : " + username);
		}
		return user;
	}

}
