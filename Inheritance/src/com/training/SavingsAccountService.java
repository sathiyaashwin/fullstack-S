package com.training;

import com.training.model.SavingsAccount;

public class SavingsAccountService extends BankAccountService {
	
	public String getCustomerInfo(SavingsAccount account) {
		
		return account.getAccountHolderName();
	}

	@Override
	public double calculateInterest(BankAccount account) {
		// TODO Auto-generated method stub
		double simpleInterest =0.10;
		if(account.getAccountNumber()<5000)
		{
			simpleInterest=0.20;
		}
		return super.calculateInterest(account);
	}
}
