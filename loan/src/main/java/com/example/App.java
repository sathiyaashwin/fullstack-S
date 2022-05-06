package com.example;

import java.sql.Connection;

import com.example.entity.Customer;
import com.example.entity.CustomerRepository;
import com.example.entity.LoanApplication;
import com.example.util.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Connection con;
        try {
			con = ConnectionFactory.getOracleConnection();
			System.out.println(con);
			
			CustomerRepository service = new CustomerRepository(con);
			//Customer cus = new Customer(105,"Abishek",869490447,500);
			//LoanApplication loan = new LoanApplication(506,cus,800000);
			//System.out.println(service.add(loan));
			
			service.remove(502);
			service.findAll().forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
 