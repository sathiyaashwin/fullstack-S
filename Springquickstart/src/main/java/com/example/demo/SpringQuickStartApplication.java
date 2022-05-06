package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Bill;
import com.example.demo.model.CustomerList;
import com.example.demo.model.Invoice;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;

@SpringBootApplication
public class SpringQuickStartApplication {

	public static void hello() {
		String args = null;
		ApplicationContext ctx =SpringApplication.run(SpringQuickStartApplication.class, args);
		
		// When Using Id Need to cast to specific Bean since 
		// return type of getBean Method is Object 
		Student ram = (Student)ctx.getBean("ram");
		
		// casting not required, but there should be only one bean of that type 
		Student shyam = ctx.getBean(Student.class);
		
		// When More than One Bean of the same Type available 
		// should use id and class name 
		Teacher stella = ctx.getBean("stella", Teacher.class);
		
		stella.setId(201);
		stella.setName("gowshick");
		stella.setSubject("fluid mech");
		
		System.out.println(stella);
		
	}
	
	public static void main(String[] args)
	{
		ApplicationContext ctx =SpringApplication.run(SpringQuickStartApplication.class, args);
		
		Invoice inv = ctx.getBean(Invoice.class);
		
		System.out.println(inv);
		
		Bill inv1 = ctx.getBean(Bill.class);
		
		System.out.println("customer :"+inv1.getCustomer());
		
		System.out.println("product :"+inv1.getProduct());
		
		CustomerList list = ctx.getBean(CustomerList.class);
		
		list.getCustList().forEach(System.out::println);
	}
}
