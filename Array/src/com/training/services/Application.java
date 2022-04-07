package com.training.services;

import com.training.model.BankAccount;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankAccountService service=new BankAccountService();
		
	    BankAccount ram= new BankAccount(1200, "rajesh", 5000);
	    double SimpleInterest =service.calculateInterest(ram)
;
	    System.out.println("Simple Interest: "+SimpleInterest);
	    
	    BankAccountService service1=new BankAccountService();
	    
	    BankAccount ram1= new BankAccount(6200, "raj", 5000);
	    double SimpleInterest1 =service1.calculateInterest(ram1);
	    System.out.println("Simple Interest: "+SimpleInterest1);
	    
//	    BankAccount[] accounts=new BankAccount[2]; in this we declaring and init is done on the diff
//	    accounts[0]=ram;
//	    accounts[1]=ram1;
//	    service.CalculateInterest(accounts);
	    BankAccount[] accounts= {ram , ram1}; //in this we declaring and init is done on the same
	    
	    service.calculateInterest(accounts);
	    
	    System.out.println("===================");
	    double[] values = service.findInterest(accounts);
	    		
	    		for(double eachValue : values) {
	    		
	    			System.out.println(eachValue);
	    		}
	    		
	    		System.out.println("=================================");
	    		BankAccount[] accountList = {
	    				new BankAccount(800,"jay",5000,"savings"),
	    				new BankAccount(800,"kam",6000,"fixed"),
	    				new BankAccount(800,"tom",7000,"recurring")
	    			};
	    		}
	    
	    		
	}

