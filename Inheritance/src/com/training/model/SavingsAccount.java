package com.training.model;

import com.training.BankAccount;

public class SavingsAccount extends BankAccount {
	
	private String nominee;
	
	//when ever sub class constructor is called its super class constructor also called
	//even if super() key word is not present
	
	public String getNominee() {
		return nominee;
	}


	public void setNominee(String nominee) {
		this.nominee = nominee;
	}


	public SavingsAccount() {
		super();
		System.out.println("Constructor of SUB CLASS CALLED");
	}

	
	public SavingsAccount(int accountNumber,String accountHolderName, double balance,String accountType,String nominee) {
		super(accountNumber,accountHolderName,balance,accountType);
		this.nominee=nominee;
	}
	
}
