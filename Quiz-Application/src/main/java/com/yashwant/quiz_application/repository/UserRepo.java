package com.yashwant.quiz_application.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yashwant.quiz_application.entity.User;

public interface UserRepo extends JpaRepository<User, String>{

	@Query(value = "select * from user where user_email = :email", nativeQuery = true)
	User getUserByEmail(String email);

	@Query(value = "select * from user where user_name = :name", nativeQuery = true)
	Page<User> getUserByName(String name, Pageable pageable);

}
