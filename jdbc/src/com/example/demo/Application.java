package com.example.demo;
import java.sql.*;

import com.example.demo.services.ProductService;
import com.example.entity.Product;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con;
		try {
		con = DriverManager.getConnection("jdbc:oracle:thin:@10.90.1.105:1521/DEV","HR","HR");
		
		ProductService service = new ProductService(con);
		
	//	Product toAdd = new Product(5,"cpu",200.00);
		
	//	int rowAdded = service.addProduct(toAdd);
		
		//System.out.println("Row Added : "+rowAdded);
		
		service.deleteById(6);
		
//		service.findAll().forEach(System.out::println);
		
		System.out.println(service.findById(2));
		
		service.updatePriceByName("cpu", 80);
		
		service.findAll().forEach(System.out::println);
		
		
		Product kathli = new Product(89, "bird", 450.00);
		
		Product cream = new Product (95, "ice", 300.00);
	
		service.usingTxn(kathli, cream);
		
	} catch (SQLException e) {
		e.printStackTrace();
		}
	}
}
