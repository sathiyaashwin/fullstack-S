package com.example.demo.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.services.Employee_Details_Service;
import com.example.demo.entity.*;

/*
 * EmployeeDetails Controller To manage Add and Update Employee Details*/
@RestController

@RequestMapping(path = "api/v1")

public class EmployeeDetailsController {

	@Autowired
	private Employee_Details_Service service;
	/*API - 1
	 * GET API To fetch All Employee Details*/
	@GetMapping(path = "/employees")
	public List<Employee_Details> getEmployee() {
		List<Employee_Details> list =service.getEmpDetails();
		int response = list.size();
		service.transactionstatus(" ",response+"Employee Details Retrieved from DB");
		return service.getEmpDetails();	
	}
	
	/*API - 1
	 * POST API To insert Employee Details*/
	@PostMapping(path="/employees")
	@RolesAllowed({"ADMIN"})
	public Employee_Details addUser(@RequestBody Map<String,String> entity) {
		Employee_Details response =this.service.add(entity);
		service.transactionstatus(entity, response);
		return response;
	}
	/*API  - 1
	 * PUT API to Update Employee Details*/
	@PutMapping(path="/employees")
	public ResponseEntity <Employee_Details> updateEmployee(@RequestBody Employee_Details entity) {
		
		Employee_Details updated = this.service.updateEmployee(entity);
		service.transactionstatus(entity, updated);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
		
	}
	
	@PutMapping(path="/employees/associate")
	@RolesAllowed({"MANAGER"})
	public Object associateManager(@RequestBody Map<String,String> request) {
		service.transactionstatus(request,service.associateEmployees(request));
		
		return service.associateEmployees(request);
	}
	
	
	
	
}
