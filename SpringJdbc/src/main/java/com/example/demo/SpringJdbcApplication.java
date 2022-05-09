package com.example.demo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.example.demo.entity.Product;
import com.example.demo.repos.ProductRepository;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SpringJdbcApplication.class, args);
		
		ProductRepository repo = ctx.getBean(ProductRepository.class);
		
		Product tv = ctx.getBean(Product.class);
		
		//System.out.println("Row Added :- " + repo.add(tv));
		
		//repo.findAll().forEach(System.out::println);
		Optional<Product> opt =repo.findById(91);
		
		if(opt.isPresent()) {
			System.out.println("findById :- "+opt.get());
		}
		else
			System.out.println("Invalid Product Id da");
		//System.out.println("findById :- "+repo.findById());
		
		//System.out.println("updated :- "+ repo.update(tv));
		
		//System.out.println("deleted row : -" +repo.remove(80));
		repo.findAll().forEach(System.out::println);
	}
	
	@Bean
	public Product tv() {
		return new Product(9,"Sony Tv",4000);
	}
	@Bean
	@Primary
	public Product ipod(){
		return new Product(9,"Hp laptop",5000);
	}
}
