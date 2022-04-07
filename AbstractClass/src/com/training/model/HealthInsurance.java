package com.training.model;

public class HealthInsurance extends Insurance {
	private String[] preExistingDiseases;
	
	public HealthInsurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HealthInsurance(int policyNumber, String policyholderName, String[] preExistingDiseases) {
		super(policyNumber, policyholderName);
		this.preExistingDiseases = preExistingDiseases;
	}

	public String[] getPreExistingDiseases() {
		return preExistingDiseases;
	}

	public void setPreExistingDiseases(String[] preExistingDiseases) {
		this.preExistingDiseases = preExistingDiseases;
	}

	public HealthInsurance(int policyNumber, String policyholderName) {
		super(policyNumber, policyholderName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculatePremium() {
		double premium = 10000;
		for(String eachItem : preExistingDiseases){
			//String item = eachItem.toLowerCase();
			if(eachItem.equalsIgnoreCase("BP") || eachItem.equalsIgnoreCase("sugar")) {
				premium = 15000;
			}
		}
		return premium;
	}
}