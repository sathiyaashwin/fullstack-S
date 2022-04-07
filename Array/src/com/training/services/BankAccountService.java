package com.training.services;

import com.training.model.BankAccount;

public class BankAccountService {
	
	public double calculateInterest(BankAccount account)
	{
		double simpleInterst =0.05;
		if(account.getAccountNumber()<5000)
		{
			simpleInterst=0.06;
		}
		return account.getBalance()*1*simpleInterst;
	}
	//overload method 
	public void calculateInterest(BankAccount[] accounts)
	{
		for (BankAccount eachAccount : accounts)
		{
			System.out.println(calculateInterest(eachAccount));
		}
	}
	
	public double[] findInterest(BankAccount[] accounts) {
		
		double[] values = new double[accounts.length];
		
		int i = 0;
		
		for(BankAccount eachAccount : accounts) {
			
			values[i]= calculateInterest(eachAccount);
			i++;
		}
		return values;
	}
	private double calculateByAccountType(BankAccount account,double rateOfInterest) {
		
		return account.getBalance()*1*rateOfInterest;
	}
	public double[] findInterestByAccountType(BankAccount[] accounts) {
		
		// USing the feature of java 7, i.e switch case with String
		double [] value= new double[accounts.length];
		int i=0;
		for(BankAccount eachAccount : accounts) {
		
		String key = eachAccount.getAccountType();
		switch (key)
 {
		case "savings":
			value[i]= calculateByAccountType(eachAccount,0.05);
			break;
			
		case "fixed":
			value[i]= calculateByAccountType(eachAccount,0.07);
			break;
			
		case "recurring":
			 value[i]= calculateByAccountType(eachAccount,0.07);
			break;
			
		default:
			break;
		}
		i++;
	}
		return value;
	}

}