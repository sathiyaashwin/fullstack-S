package com.training;

public class Application {

	public static void main(String[] args) {
		
		Customer cus = new Customer(011,"abbey yar",9176,"sathiya@gmail.com");
		System.out.println(cus.getMailId());
		cus.setCustomerName("gowsick");

	}

}