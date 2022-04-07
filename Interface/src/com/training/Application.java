package com.training;

import com.training.ifaces.*;
import com.training.ifaces.CurrencyConverter;

public class Application {

	public static void main(String[] args) {
		
		Function conv = new CurrencyConverter(); //becozz currency converter is implementing Function
		
		
		double response = conv.apply(200);
		System.out.println(response);		//line 11&12 and line 14 is same(just for understanding) 

		
		System.out.println(conv.apply(200));
		
		System.out.println(Function.Counter);
		System.out.println(response);
		
		if(conv instanceof CheckCondition) {
			CheckCondition obj = (CheckCondition)conv;
			
			System.out.println(obj.test(300));
		}else {
			System.out.println("Cannot be cast");
			
		}
		Conditional condition = new DiscountCalculator();
		System.out.println(condition.test(600));
		System.out.println(condition.negate(300));

	}

}