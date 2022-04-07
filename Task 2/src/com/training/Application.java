package com.training;

public class Application {

	public static void main(String[] args) {
		
		
		
		
		Address obj1 = new Address(5,"2nd Street","thiruvika nagar",600055);
		MobileBill obj = new MobileBill("gowshick",857906967,"prepaid",obj1); 
		
		System.out.println("Name - "+obj.getCustomerName());
		System.out.println("Mobile number - "+obj.getMobileNumber());
		System.out.println("Mobile plan - "+obj.getPlanName());
		System.out.println("Address - "+obj.getAddress());
		System.out.println(MobileBill.BRAND);
		System.out.println("amount - "+obj.findAmount());
		
		
		
		//System.out.println("Address :- "+obj1.doorNumber+","+obj1.streetName+","+obj1.areaName+","+obj1.pincode);

	}

}