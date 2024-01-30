package com.yashwant.quiz_application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yashwant.quiz_application.entity.Role;
import com.yashwant.quiz_application.repository.RoleRepo;

@SpringBootApplication
public class QuizApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		try
		{
			Role role = new Role();
			role.setRoleId("admin");
			role.setRoleName("Admin");
			
			Role role1 = new Role();
			role1.setRoleId("user");
			role1.setRoleName("Normal_User");
			
			List<Role>roles = List.of(role,role1);
			List<Role>result = this.roleRepo.saveAll(roles);

		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
