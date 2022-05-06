package com.training.ifaces;

public class StudentResultService implements Conditional<Double>,AgeCondition<Double> {

	@Override
	public boolean test(Double t) {
		// TODO Auto-generated method stub
		return t>80;
	}

	@Override
	public boolean negate(Double value) {
		
		
		
		boolean result1 =Conditional.super.negate(value);
		//return result1;
		
		boolean result2 = AgeCondition.super.negate(value);
		
		
		if(result1 && result2){
			return true;
		}else {
			return false;
		}
			
	}
}
