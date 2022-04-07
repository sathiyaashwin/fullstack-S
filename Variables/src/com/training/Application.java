package com.training;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account = new BankAccount("Ramesh",1000);
		
		System.out.println("current bal of ramesh = "+account.getUpdatedBalance(2000));
		System.out.println("current bal of ramesh = "+account.getUpdatedBalance(3000));
		System.out.println("account number = "+account.getAccountNumber());
		
		//System.out.println(BankAccount.getCount());
		
		
		BankAccount account2 = new BankAccount("Suresh",2000);
		
		System.out.println("current bal of suresh = "+account2.getUpdatedBalance(3000));
		System.out.println("account number = "+account2.getAccountNumber());
	}

}
