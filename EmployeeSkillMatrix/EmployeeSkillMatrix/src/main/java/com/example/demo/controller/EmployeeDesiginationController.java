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

import com.example.demo.entity.Employee_Designation;
import com.example.demo.entity.Transaction_Log;
import com.example.demo.repo.TransactionRepo;

import com.example.demo.services.Employee_Desigination_Service;

@RestController
@RequestMapping(path = "api/v1")
public class EmployeeDesiginationController {
	@Autowired
	private TransactionRepo repo;
	@Autowired
	private Transaction_Log transaction;

	
	public void transactionstatus(Object obj1,Object obj2) {
        transaction.setApiOperationName("EmployeeDesigination");
	    
		
		transaction.setCreatedTime(LocalTime.now());
		
		transaction.setCreatedDate(LocalDate.now());
		
		transaction.setRequest(obj1.toString());
		
		transaction.setResponse(obj2.toString());
		this.repo.save(transaction);
		}
	
	@Autowired
	private Employee_Desigination_Service service;
	
	@PostMapping(path="/employeeDesig")
	public Employee_Designation addUser(@RequestBody Employee_Designation entity) {
		return this.service.addEmpDesig(entity);
	}
	
	@GetMapping(path = "/employeeDesig")
	public List<Employee_Designation> getUser() {
		return service.getEmpDesig();	
	}
	
	@PutMapping(path = "/employeeDesig")
	public ResponseEntity<Employee_Designation> updateEmployeeDesignation(@RequestBody Employee_Designation empDetails) {
		return ResponseEntity.status(201).body(empDetails);
	}
	
	


}
