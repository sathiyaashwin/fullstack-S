package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Seminar;
import com.example.demo.entity.Speaker;
import com.example.demo.repo.SeminarRepository;

import com.example.demo.utils.*;
@SpringBootApplication
public class SpringDataJpaSimpleOne2oneApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataJpaSimpleOne2oneApplication.class, args);
	
		SeminarUtils obj =ctx.getBean(SeminarUtils.class);
		obj.create();
		obj.findAll();
		
		ctx.close();
		
	
	}
	@Bean
	public Speaker vishnu() {
		return new Speaker(101,"Vishnu","BE");
	}
	@Bean
	public Seminar clg() {
		Seminar sem = new Seminar();
		sem.setId(11);
		sem.setName("collage");
		sem.setDuration(2);
		
		return sem;
	}

}
