package com.training.ifaces;

public interface AgeCondition<T> {
	
	default boolean negate(Double age) {
		
		return age<58;
	}

}
