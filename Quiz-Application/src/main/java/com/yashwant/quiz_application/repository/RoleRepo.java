package com.yashwant.quiz_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashwant.quiz_application.entity.Role;



public interface RoleRepo extends JpaRepository<Role, String>{

}