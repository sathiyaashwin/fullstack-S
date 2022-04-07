package com.training.model;

public class LifeInsurance extends Insurance {

	private int age;

	public LifeInsurance(int age) {
		super();
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public LifeInsurance(int policyNumber, String policyHolderName, int age) {
		super(policyNumber, policyHolderName);
		this.age = age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public double calculatePremium() {
	double premium = 1000;
		if(age <50) {
			premium = 5000;
			}
		return premium;
	

}
}
