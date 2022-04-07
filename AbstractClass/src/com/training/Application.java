package com.training;

import com.training.model.*;

public class Application {

	public static void printPremium(Insurance object)
	{
		System.out.println(object.calculatePremium());
	}	
	public static void main(String[] args) {
		
		VehicleInsurance car = new VehicleInsurance(1010,"gowsick","car",2019);
		
		printPremium(car);
		
		LifeInsurance life = new LifeInsurance(1010, "Lokesh", 50);
		printPremium(life);
		
		String[] illness = {"bp","sugar","ent"};
		HealthInsurance health = new  HealthInsurance(656, "sathiya", illness);
		printPremium(health);


	}

}
