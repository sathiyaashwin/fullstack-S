package com.training.services;

import com.training.ifaces.*;


public class CurrencyConverter implements Converter<Double, Double> {

	@Override
	public Double convert(Double value) {
		return value * 100.00;
	}
	
}