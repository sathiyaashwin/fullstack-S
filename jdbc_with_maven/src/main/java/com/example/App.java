package com.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import com.example.entity.Member;
import com.example.entity.MemberRepository;
import com.example.util.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Connection con ;
    	try {
    		
//    		con = ConnectionFactory.getOracleConnection();
//    		
//    		System.out.println(con);
    		
    		
    		con = DriverManager.getConnection("jdbc:oracle:thin:@10.90.1.105:1521/DEV","HR","HR");
    		System.out.println(con);
    		
    		//LocalDate date = LocalDate.of(2022,4,12);
    		//Date sqlDate = Date.valueOf(date);
    		//LocalDate date2 = sqlDate.toLocalDate();
    		
    		MemberRepository service = new MemberRepository(con);
    		//Member toAdd = new Member(114,"Gowshickk","Cuddalore",sqlDate,"Annual",2400,7,100);
    		// int rowAdded = service.add(toAdd);
    		// System.out.println("Row Added : "+rowAdded);
    		//Optional<Member> found=service.findById(105);
    		//Member mem = new Member("Gopi");
    		//System.out.println(service.add(mem));
    		//if(found.isPresent()) {
    		//	System.out.println(found);
    		//}
    		//else {
    		//	System.out.println("Value is invalid");
    		//}
    		
    		//service.remove(106);
    		service.update1(104,"gowse");

    		service.findAll().forEach(System.out::println);
    		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
        
    }
}
//108
//111
//106
//107
//11
//119
//105