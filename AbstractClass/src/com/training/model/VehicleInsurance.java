package com.training.model;

public  class VehicleInsurance extends Insurance {
	private String vehicleModel;
	private int yearOfManufacture;
	
	
	public VehicleInsurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VehicleInsurance(int policyNumber, String policyHolderName, String vehicleModel,
			int yearOfManufacture) {
		super(policyNumber, policyHolderName);
		this.vehicleModel = vehicleModel;
		this.yearOfManufacture = yearOfManufacture;
	}
	
	public String getVechicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public int getYearOfManufacture() {
		return yearOfManufacture;
	}
	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}
	
	@Override
	public double calculatePremium() {
		double premium=1000;
		if(yearOfManufacture<2020 && vehicleModel.equals("car")) {
			premium=2000;
		}
		return premium;
	}


}