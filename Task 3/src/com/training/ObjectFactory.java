package com.training;

public class ObjectFactory {
	
	public AutoMobile getObject(int key)
	{
		switch (key)
 {
		case 1:
			return new MarutiCar();
		case 2:
			return new ToyotaCar();
		default:
			return null;
		}

	}
	public void printQoute(AutoMobile poly){
		
		System.out.println(poly.getModel());
		System.out.println(poly.getColor());
		System.out.println(poly.getPrice());
		
		
	}
	
	
}