package com.training;

public class Address {
	
	
	public int doorNumber;
	public String streetName; 
	public String areaName;
	public int pincode;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(int doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Address(int doorNumber, String streetName, String areaName, int pincode) {
		super();
		this.doorNumber = doorNumber;
		this.streetName = streetName;
		this.areaName = areaName;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [doorNumber=" + doorNumber + ", streetName=" + streetName + ", areaName=" + areaName
				+ ", pincode=" + pincode + "]";
	}
	
	
}
