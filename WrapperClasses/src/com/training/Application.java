package com.training;

public class Application {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
//		
//		System.out.println(args[0]);
//		System.out.println(args[1]);
//		System.out.println(args[2]);
//		
//		int value = Integer.parseInt(args[0]);
//		
//		System.out.println(++value);
		
		CurrencyConverter conv = new CurrencyConverter();
		
		double usdvalue = Double.parseDouble(args[0]);
		
		System.out.println(conv.inrToUsd(usdvalue));
		
		double eurovalue = Double.parseDouble(args[1]);
		
		System.out.println(conv.inrToEuro(eurovalue));
		
		double salary = 42500.00;
		
		int sal = (int)salary;
		
		int age = 42;
		
		String strAge = Integer.toString(age) ;
		
		System.out.println(strAge);
		System.out.println(sal);
	}

}
