package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeDesignation;
import com.example.demo.entity.TransactionLog;
import com.example.demo.repo.TransactionLogRepository;
import com.example.demo.service.EmployeeDesginationService;

@RestController
@RequestMapping(path = "api/v1")
public class EmployeeDesignationController {
	@Autowired
	private TransactionLogRepository repo;
	
	@Autowired
	private TransactionLog transactionLog;
	
	@Autowired
	private EmployeeDesginationService service;

	
	public void transactionstatus(Object obj1,Object obj2) {
		
        transactionLog.setApiOperationName("EmployeeDesigination");  
		
		transactionLog.setCreatedTime(LocalTime.now());
		
		transactionLog.setCreatedDate(LocalDate.now());
		
		transactionLog.setRequest(obj1.toString());
		
		transactionLog.setResponse(obj2.toString());
		
		this.repo.save(transactionLog);
		}
	
	
	@PostMapping(path="/employeeDesig")
	public EmployeeDesignation addUser(@RequestBody EmployeeDesignation entity) {
		return this.service.addEmpDesig(entity);
	}
	
	@GetMapping(path = "/employeeDesig")
	public List<EmployeeDesignation> getUser() {
		return service.getEmpDesig();	
	}
	
	@PutMapping(path = "/employeeDesig")
	public ResponseEntity<EmployeeDesignation> updateEmployeeDesignation(@RequestBody EmployeeDesignation empDetails) {
		return ResponseEntity.status(201).body(empDetails);
	}

}
