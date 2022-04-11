package com.training;

import com.training.InvalidEmailException;;

public class Customer {

	private int customerId;
	private String CustomerName;
	private long mobileNumber;
	private String mailId;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Customer(int customerId, String customerName, long mobileNumber, String mailId) {
		super();
		if(mailId.endsWith(".com") || mailId.endsWith(".org") || mailId.endsWith(".in") &&
		mailId.contains("@"))
		{
			this.mailId= mailId;
			this.customerId = customerId;
			this.CustomerName = customerName;
			this.mobileNumber = mobileNumber;
		}
		else {
			
			try {
				throw new InvalidEmailException("Invaild email");
			} catch (InvalidEmailException e) {
				e.printStackTrace();
			}
		}
	}
		



	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		this.CustomerName = customerName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) throws InvalidEmailException {
		
		if(mailId.endsWith(".com") || mailId.endsWith(".org") || mailId.endsWith(".in") &&
		mailId.contains("@"))
		{
			this.mailId= mailId;
		}else {
			throw new InvalidEmailException("Invalid");
		}

	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", CustomerName=" + CustomerName + ", mobileNumber="
				+ mobileNumber + ", mailId=" + mailId + "]";
	}
	
	
}
