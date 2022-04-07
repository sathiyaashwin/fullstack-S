package com.training;

import java.util.*;
import com.training.customer.*;
import com.training.hotel.*;
import com.training.employee.*;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Hotel hol = new Hotel();
		
		System.out.println("Enter name of hotel");
		String name = sc.next();
		System.out.println("Enter hotel contact number");
		Long number = sc.nextLong();
		System.out.println("Enter hotel type");
		String type = sc.next();
		System.out.println("Enter hotel location");
		String loc = sc.next();
		//hol.setHotelname(name);
		//System.out.println(hol.getHotelname());
		System.out.println("---------------------------------------------------------------------");
		hol.setHotelname(name);
		hol.setHotelnumber(number);
		hol.setHoteltype(type);
		hol.setHotellocation(loc);
		System.out.println("Hotel Name              - "+hol.getHotelname());
		System.out.println("Hotel contact number    - "+hol.getHotelnumber());
		System.out.println("Hotel Type              - "+hol.getHoteltype());
		System.out.println("Hotel location          - "+hol.getHotellocation());
		
		System.out.println("---------------------------------------------------------------------");
		
		Employee emp = new Employee();
		System.out.println("Enter employee Name");
		String ename = sc.next();
		System.out.println("Enter Employee ID");
		int eid = sc.nextInt();
		System.out.println("Enter Employee Salary");
		Long enumm = sc.nextLong();
		System.out.println("---------------------------------------------------------------------");
		emp.setEmployeid(eid);
		emp.setEmployename(ename);
		emp.setEmployenumber(enumm);
		System.out.println("Employee Name           - "+emp.getEmployename());
		System.out.println("Employee ID             - "+emp.getEmployeid());
		System.out.println("Employee Salary         - "+emp.getEmployenumber());
		
		System.out.println("---------------------------------------------------------------------");
		
		Customer cus = new Customer();
		System.out.println("Enter Customer Name");
		String cname = sc.next();
		System.out.println("Enter Customer ID");
		int cid = sc.nextInt();
		System.out.println("Enter Customer contact number");
		long cnum = sc.nextLong();
		
		System.out.println("---------------------------------------------------------------------");
		cus.setCustomername(cname);
		cus.setCustomerid(cid);
		cus.setCustomernumber(cnum);
		System.out.println("Customer Name           - "+cus.getCustomername());
		System.out.println("Customer ID             - "+cus.getCustomerid());
		System.out.println("Customer contact number - "+cus.getCustomernumber());
		
		System.out.println("---------------------------------------------------------------------");
		
		
		sc.close();

	}

}