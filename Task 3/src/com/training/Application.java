package com.training;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ObjectFactory ob=new ObjectFactory();
		AutoMobile Maru = ob.getObject(1);
		AutoMobile toyo = ob.getObject(2);
		System.out.println("=======================================");
		ob.printQoute(Maru);
		System.out.println("=======================================");
		ob.printQoute(toyo);
		System.out.println("=======================================");
}
}