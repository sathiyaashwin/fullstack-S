package com.training.ifaces;

import java.util.Optional;

public class UsingOptional {
	
	public static Object getString(int key) {
		
		switch(key) {
		case 1:
			return new String("Chocobar");
		case 2:
			return new StringBuffer("Cassata");
			
		default:
			return null;
			
		}
	}

	public static void main(String[] args) {
		
		// will  throw pointer exception
		
		
		//System.out.println(getString(3).toString());
		
		//to avoid nullpointer exception and return a default value
		// New feature of java 8 Optional is used
		
		//Optional<Object> optional = Optional.ofNullable(getString(5));
		
		//System.out.println(optional.orElse("Vannila".toString()));
		
		//here we are checking if the value is present
		// if it presents then only we will call get method
		
		
		Optional<Object> opt2 = Optional.ofNullable(getString(3));		
		if(opt2.isPresent()){
			System.out.println("Value is Present "+opt2.get());
		}else {
			System.out.println("Value is not Present");
		}
		
		//using lambda expression with optional
		//Optional<Object> opt3 = Optional.ofNullable(2);
		}
	}


