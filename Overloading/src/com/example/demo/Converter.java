package com.example.demo;

public class Converter {
	
	public String convert(String str) {
		
		return str.toLowerCase(); // to make lower case
	}
	
//	public String convert(String str2) {
//		return null;
//	}

	// Creating a Overloaded Method
	
	public double convert(double farenTemp) {
		return (farenTemp-32)*5/9;
	}
	public double convert(double amt,int frm) {
		
		
		if(frm==1) {
			
			return amt* 100;
		}else {
			
			return amt* 120;
		}
	}
}
