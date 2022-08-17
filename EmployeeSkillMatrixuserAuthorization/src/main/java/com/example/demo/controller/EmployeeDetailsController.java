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

import com.example.demo.entity.EmployeeDetails;
import com.example.demo.service.EmployeeDetailsService;

@RestController
@RequestMapping(path = "api/v1")

public class EmployeeDetailsController {
	
	@Autowired
	private EmployeeDetailsService service;
	
	// fetch All Employee Details
	@GetMapping(path = "/employees")
	public List<EmployeeDetails> getEmployee() {
		List<EmployeeDetails> list =service.getEmpDetails();
		int response = list.size();
		service.transactionstatus(" ",response+"Employee Details Retrieved from DB");
		return service.getEmpDetails();	
	}
	
	// To insert Employee Details
	@PostMapping(path="/employees")
	@RolesAllowed({"ADMIN"})
	public EmployeeDetails addUser(@RequestBody Map<String,String> entity) {
		EmployeeDetails response =this.service.add(entity);
		service.transactionstatus(entity, response);
		return response;
	}

	 //Update Employee Details
	@PutMapping(path="/employees")
	public ResponseEntity <EmployeeDetails> updateEmployee(@RequestBody EmployeeDetails entity) {
		
		EmployeeDetails updated = this.service.updateEmployee(entity);
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
