package com.training;

public class MobileBill {
	
	private String customerName;
	private long mobileNumber;
	private String planName;
	private Address address;
	public static final String BRAND = "Airtel";
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public MobileBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MobileBill(String customerName, long mobileNumber, String planName, Address address) {
		super();
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.planName = planName;
		this.address = address;
	}
	public int findAmount() {
		
		String key = this.planName;
				
		switch(key) {
		
		case "prepaid":
			return 200;
			
		case "postpaid":
			return 300;

		default:
			return 0;
		}
	}
	
	
	

}
