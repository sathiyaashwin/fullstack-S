package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.utils.Utility;

@SpringBootApplication
public class SpringDataJpaSimpleBidirectionalApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx =SpringApplication.run(SpringDataJpaSimpleBidirectionalApplication.class, args);
	
		Doctor doc = ctx.getBean(Doctor.class);
		Utility obj = ctx.getBean(Utility.class);
		//obj.create();
		//obj.findAll();
		obj.findDoctorFromPatient();
		
		ctx.close();	
	}
	
	@Bean
	public Doctor michael() {
		Doctor doc = new Doctor();
		doc.setDoctorId(1001);
		doc.setDoctorName("Michael");
		doc.setDepartment("heart");
		doc.setPhoneNumber(4839763);
		
		return doc;
	}
	@Bean
	public Patient avi()
	{
		return new Patient(301,"Avinash",6838564);
	}
	
	@Bean
	public Patient thiru()
	{
		return new Patient(302,"Thiruvikram",5758578);
	}
	
	@Bean
	public Patient leo()
	{
		return new Patient(303,"Leo Gopi",9678568);
	}
	
	@Bean
	public Patient lokesh()
	{
		return new Patient(304,"Lokesh",8975647);
	}
	
}

