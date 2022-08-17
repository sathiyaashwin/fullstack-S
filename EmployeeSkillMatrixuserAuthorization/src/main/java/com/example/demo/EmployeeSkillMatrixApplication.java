package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.entity.TransactionLog;

@SpringBootApplication
public class EmployeeSkillMatrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSkillMatrixApplication.class, args);
	}
	
//	@Bean
//	public User pavi() {
//		return new User(101,"pavi","pavi@123","pavi","thra",LocalDate.of(2001, 4, 22)
//				,"pavi",LocalTime.of(4, 32),"pavi"); 
//		
//	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public TransactionLog log() {
		return new  TransactionLog(); 
	}
	

}
