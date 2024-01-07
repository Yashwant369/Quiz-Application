package com.yashwant.quiz_application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	private String userId;
	private String userName;
	@Column(unique = true)
	private String userEmail;
	private String password;
	

}
