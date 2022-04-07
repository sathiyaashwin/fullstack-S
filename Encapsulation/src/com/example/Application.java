package com.example;

import com.example.model.Student;

public class Application {
	
	public static void main(String[] args) {
		
		Student ram = new Student();
		
		//ram.rollNumber = 101;
		
		//public method unable to access
		ram.setRollNumber(56020);
		/*default method unable to access
		 because student class is in com.example.model package
		and Application is in com.example package*/
		ram.setFirstName("Gowshick");
		/*Unable to access because Application is NOT a Subclass
		of student*/
		ram.setMarkScored(100);
		//Unable to access because the method is in private in student  class
		
		
		ram.setBranch("CSE");
		
		System.out.println("Roll number : " +ram.getRollNumber());
		System.out.println("Mark Scored : " +ram.getMarkScored());
		System.out.println("Student Name : " +ram.getFirstName());
		System.out.println("Student branch : " +ram.getBranch());
	}
}
