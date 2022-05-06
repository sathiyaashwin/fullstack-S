package com.training.ifaces;

public interface Conditional<T> {
	
	public boolean test (T t);
	
	default boolean negate (Double value ) {
		
		return value<=80.00;
	}	
	public static String getMessage() {
			
			return "Static method is interface- Yes its real"; 
		}

}
