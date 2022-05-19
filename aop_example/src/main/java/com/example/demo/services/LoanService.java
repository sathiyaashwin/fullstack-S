package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class LoanService {
	
	public double getInterestRate(int i) {
		System.out.println(i);
		return 4.5;
	}

}
