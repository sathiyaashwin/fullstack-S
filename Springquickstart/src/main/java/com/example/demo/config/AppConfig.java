package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;

@Configuration
public class AppConfig {
	
	// Id of the bean is same as the method name
	@Bean
	public Student ram() {
		return new Student(101,"Ramesh",69);
	}
	
	@Bean
	public Teacher harish()
	{
		
		return new Teacher (201,"ram","hello");
	}

	
	@Bean
	public Product tv()
	{
		
		return new Product (201,"sony tv");
	}

	
	@Bean
	public Customer suresh()
	{
		
		return new Customer(201,"suresh");
	}
	
	@Bean
	public Customer rajesh()
	{
		
		return new Customer(202,"rajesh");
	}
	
	@Bean
	public Customer magesh()
	{
		
		return new Customer(203,"magesh");
	}
}
