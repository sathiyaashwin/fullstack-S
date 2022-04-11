package com.training;

import java.util.Scanner;

import com.training.exception.RangeCheckException;
import com.training.model.Student;
import com.training.servies.ExceptionHandling;
import com.training.servies.StudentService;

public class Application {

	public static void main(String[] args) throws Exception {
		
//		Student loki=null;
//		try {
//			loki = new Student(4052, "lokesh", 90);
//		} catch (RangeCheckException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		StudentService service=new StudentService(loki);
//		System.out.println(service.sendDetails());
//		
//		StudentService service2=new StudentService(loki);
//		try {
//			System.out.println("GRADE:"+service2.findRank());
//			System.out.println("Summa");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			System.err.println("Name is not passed");
//		}
//		
		ExceptionHandling exHandling = new ExceptionHandling();
		//exHandling.usingArrayIndexException(args);
		
		//exHandling.usingNumberFormatException("45");
		
		System.out.println(exHandling.usingStandFinallyBlock());
		//Since we are try with resource - Scanner will be closed
		
		Scanner scan =new Scanner(System.in) ;
		try(Scanner scan1 = new Scanner(System.in)) {
			System.out.println("Enter Number");
			int num = scan1.nextInt();
			
			System.out.println(num);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}