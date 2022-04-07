package com.example.demo;

import java.util.*;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Name");
		
		String name = sc.next();
		System.out.println("Enter the Farenheit Temp");
		double farenTemp = sc.nextDouble();
		System.out.println("Enter the amount");
		double amt = sc.nextDouble();
		System.out.println("Enter the current to convert 1 USD 2 ");
		int frm = sc.nextInt();
		
		Converter conobj = new Converter();
		
		System.out.println(conobj.convert(name));
		System.out.println(conobj.convert(amt, frm));
		
		System.out.println("Celius Temp = "+conobj.convert(farenTemp));
		
		sc.close();

	}

}
 