package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_vnk")

@Data
@AllArgsConstructor
@NoArgsConstructor 	
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_login_id")
	private int userLoginId ;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
		
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	
	@DateTimeFormat(iso = ISO.TIME)
	@Column(name="created_time")
	private LocalTime createdTime;
	
	@Column(name="token")
	private String token;
	
}
