package com.training;

import com.training.model.BankAccount;
import com.training.services.BankAccountService;

import java.util.Scanner;

public class MyApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankAccountService service = new BankAccountService();
		
		BankAccount[] list = new BankAccount[1];
		
		int idx=0;
		
		int flag = 0;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			//BankAccount account = new BankAccount();
					
					System.out.println("Account Number:");
					
					int accountNumber =  sc.nextInt();
					
					System.out.println("Account Holder Name:");
					
					String accountHolderName = sc.next();
					
					System.out.println("Balance:");
					
					double balance = sc.nextDouble();
					
					System.out.println("Account Type [savings,fixed,recurring]");
					
					String accountType = sc.next();
					
					BankAccount account1 = new BankAccount(accountNumber, accountHolderName, balance, accountType);

					list[idx]=account1;
					
					System.out.println("Enter 0 or 1:");
					flag =sc.nextInt();
					double[] values = service.findInterest(list);
					
					for(double eachValue: values) {
						System.out.println(eachValue);
					}
			}while(flag==1);
		
		
		sc.close();

	}

	
}