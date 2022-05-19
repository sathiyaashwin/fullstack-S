package com.example.demo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.LoanService;

@RestController
@RequestMapping(path="/api/v1")
public class LoanController {
	
	private LoanService service;
	
	@Autowired
	public LoanController(LoanService service) {
		super();
		this.service = service;
	}



	@GetMapping(path="/loans")
	public ResponseEntity<String> getLoanDetails(){
		
		double val = this.service.getInterestRate(600);
	
		return ResponseEntity.ok(val + "Per Annum");
	}
}
