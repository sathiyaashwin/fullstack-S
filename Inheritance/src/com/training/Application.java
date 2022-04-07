package com.training;

import com.training.BankAccount;
import com.training.model.SavingsAccount;

public class Application {

	public static void main(String[] args) {
		BankAccount ramsAccount =new BankAccount(1010,"ramesh",5000,"savings");
		System.out.println(ramsAccount);
		SavingsAccount account=new SavingsAccount(54, "raj", 5000, "Savings", "raja"); 
		System.out.println(account.getAccountHolderName());
		System.out.println(account.getNominee());
		
		BankAccountService service1= new SavingsAccountService();
		
		SavingsAccountService savingsService1=(SavingsAccountService)service1;
		
//		BankAccountService sc1= new SavingsAccountService();
//		SavingsAccountService sc2=(SavingsAccountService) sc1;
		
		System.out.println(savingsService1.getCustomerInfo(account));
//		System.out.println(sc2.getCustomerInfo(account));
	}

}