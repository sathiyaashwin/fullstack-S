package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="pavi_user_2022")
public class User {
	
	@Id
	@Column(name = "user_login_id")
    int userLoginId ;
	
	@Column(name="username")
    String userName;
	
	@Column(name="password")
    String password;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
    String lastName;
		
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="created_date")
    LocalDate createdDate;
	
	@Column(name="created_by")
	String createdBy;
	
	@DateTimeFormat(iso = ISO.TIME)
	@Column(name="created_time")
	LocalTime createdTime;
	
	@Column(name="token")
    String token;
	
}
