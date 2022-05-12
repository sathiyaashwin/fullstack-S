package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;

@SpringBootApplication
public class SpringDataJpaSimpleMappingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataJpaSimpleMappingApplication.class, args);
		
		//Doctor siva = ctx.getBean(Doctor.class);
		
		DoctorService service = ctx.getBean(DoctorService.class);
		
		
		
//		Doctor added = service.add(siva);
//		
//		if(added!=null) {
//			System.out.println("One Doctor added");
//		}
		
		//System.out.println(service.findByDoc("Yovel"));
		
		//System.out.println(service.findByDept("env"));
		
		//System.out.println(service.findByDoctorNameAndDepartment("hari", "env"));
		
		System.out.println(service.getByNameDept("Yovel","env"));
	
		ctx.close();
	}
	
//	@Bean
//	public Doctor siva() {
//		return new Doctor(2020,"Siva","ent",8959446);
//	}
	
	 
	
	@Bean
	public Doctor siva() {
		return new Doctor(202,"hari","env",89590000);
	}
}
