package com.yashwant.quiz_application.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yashwant.quiz_application.dtos.UserDto;
import com.yashwant.quiz_application.entity.Role;
import com.yashwant.quiz_application.entity.User;
import com.yashwant.quiz_application.exceptions.ResourceNotFoundException;
import com.yashwant.quiz_application.repository.RoleRepo;
import com.yashwant.quiz_application.repository.UserRepo;
import com.yashwant.quiz_application.service.UserService;
import com.yashwant.quiz_application.util.PageResponse;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	String roleId = "user";
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		String userId = UUID.randomUUID().toString();
		userDto.setUserId(userId);
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		User user = mapper.map(userDto,User.class);
		Role role = roleRepo.findById(roleId).get();
		user.getRoles().add(role);
		User newUser = userRepo.save(user);
		UserDto newUserDto = mapper.map(newUser, UserDto.class);
		return newUserDto;
		
	}

	@Override
	public UserDto updateuser(UserDto userDto, String userId) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).
				orElseThrow(()-> new ResourceNotFoundException("User not found with given id : " + userId));
				user.setUserName(userDto.getUserName());
				user.setUserEmail(userDto.getUserEmail());
				user.setUserPassword(userDto.getPassword());
				User updatedUser = userRepo.save(user);
				UserDto updatedUserDto = mapper.map(updatedUser,UserDto.class);
				return updatedUserDto;
		
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with this id : " + userId));
		userRepo.delete(user);
		
	}

	@Override
	public PageResponse<UserDto> getAllUsers(int pageNumber, int pageSize, String sortBy, String sortDir) {
		// TODO Auto-generated method stub
		Sort sort = null;
		if(sortDir.equals("asc"))
		{
			sort = Sort.by(sortBy).ascending();
		}
		else if(sortDir.equals("desc"))
		{
			sort = Sort.by(sortBy).descending();
		}
		//Sort sort = Sort.by(sortBy);
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<User>page = userRepo.findAll(pageable);
		List<User>users = page.getContent();
		if(users.size() == 0)
		{
			throw new ResourceNotFoundException("Users not present");
		}
		List<UserDto>list = new ArrayList<>();
		for(User u : users)
		{
			UserDto userDto = mapper.map(u, UserDto.class);
			list.add(userDto);
		}
		PageResponse<UserDto>response = new PageResponse<>();
		response.setContent(list);
		response.setLastPage(page.isLast());
		response.setPageNumber(page.getNumber());
		response.setPageSize(page.getSize());
		response.setTotalElements((int) page.getTotalElements());
		response.setTotalPages(page.getTotalPages());
		return response;
		
	}

	@Override
	public UserDto getUserById(String userId) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with this id : " + userId));
		return mapper.map(user, UserDto.class);
		
	}

	@Override
	public UserDto getUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user = userRepo.getUserByEmail(email);
		if(user == null)
		{
			throw new ResourceNotFoundException("User not found with given email : " + email);
		}
		return mapper.map(user, UserDto.class);
	}

	@Override
	public PageResponse<UserDto> getUserByName(String name, int pageNumber, int pageSize, String sortBy,
			String sortDir) {
		// TODO Auto-generated method stub
		Sort sort = null;
		if(sortDir.equals("asc"))
		{
			sort = Sort.by(sortBy).ascending();
		}
		else if(sortDir.equals("desc"))
		{
			sort = Sort.by(sortBy).descending();
		}
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize,sort);
		Page<User>page = userRepo.getUserByName(name,pageable);
		List<User>users = page.getContent();
		if(users.size() == 0)
		{
			throw new ResourceNotFoundException("Users not present");
		}
		List<UserDto>list = new ArrayList<>();
		for(User u : users)
		{
			UserDto userDto = mapper.map(u, UserDto.class);
			list.add(userDto);
		}
		PageResponse<UserDto>response = new PageResponse<>();
		response.setContent(list);
		response.setLastPage(page.isLast());
		response.setPageNumber(page.getNumber());
		response.setPageSize(page.getSize());
		response.setTotalElements((int) page.getTotalElements());
		response.setTotalPages(page.getTotalPages());
		return response;


	}

}
