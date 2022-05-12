package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@SpringBootApplication
public class SpringDataJpaSimpleTaskApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringDataJpaSimpleTaskApplication.class, args);
		
		EmployeeService service = ctx.getBean(EmployeeService.class);
		
		Employee ram = ctx.getBean(Employee.class);
		
		//System.out.println(service.add(ram));
		
		//System.out.println(service.findByLoc("mumbai"));
		
		//System.out.println(service.findBySkill("java"));
		
		//System.out.println(service.findByDate(LocalDate.of(2001,06,15)));

		System.out.println(service.findBySkillSetLocation("java","chennai"));
		
		//service.findAll().forEach(System.out::println);
		ctx.close();
	}
	
	@Bean
	public Employee ram() {
		return new Employee(104,"yovel",LocalDate.of(2002,9,20),"ooty","C++",6895472);
	}
}
