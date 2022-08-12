package com.example.demo.controller;


import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee_Skills;
import com.example.demo.entity.Transaction_Log;
import com.example.demo.services.Employee_Skill_Service;

@RestController
@RequestMapping(path = "api/v1")
public class EmployeeSkillsController {

	@Autowired
	public Employee_Skill_Service service;
	
	
	@GetMapping(path = "/empskills")
	public List<Employee_Skills> getUser() {
		List<Employee_Skills>  list = service.getEmployeeSkills();
		service.transactionstatus(" ","A Count Of"+ list.size()+" Employee Skills Has Been Retrieved From DB");
		return service.getEmployeeSkills();	
	}
	@PostMapping(path = "/empskills")
	public Object addEmployeeSkills(@RequestBody Map<String,String> empSkills) {
		Object emp=	service.add(empSkills);
		service.transactionstatus(empSkills,emp);
		return emp;
	}
	@PutMapping(path = "/empskills")
	public Employee_Skills updateEmployeeSkills(@RequestBody Employee_Skills empSkills) {
		return service.update(empSkills);
	}
	@GetMapping(path = "/manager/{empName}")
	public Object getEmployeeSkills(@PathVariable("empName") String empName) {
		Object list =service.getEmployeeSkills(empName);
		service.transactionstatus("Retrieving Employee Skills Who is associated with MANAGER: "+empName, list);
		return service.getEmployeeSkills(empName);	
	}
	@GetMapping(path = "/skillApproval")
	public Object getApprovedStatus(@RequestParam(value = "EmployeeName", required = true) String empName,@RequestParam(value = "Status", required = true) String status){
		Object list = service.getDraftStatus(empName, status);
		service.transactionstatus("Employee:"+ empName +" And Status: "+ status, list);
		return service.getDraftStatus(empName, status); 
	}
	

	@GetMapping(path="/search")
	public Object getEmpSkillsBasedOnInput(@RequestBody Map<String,String> search) {
		Object responce =service.srcByskills(search);
		service.transactionstatus(search, responce);
		return service.srcByskills(search);
	}
	
	@GetMapping(path="/searchInput")
	public Object getEmpSkillsBasedOnKeys(@RequestBody Map<String,String> search) {
		Object responce = service.srcByInput(search);
		service.transactionstatus(search, responce);
		return service.srcByInput(search);
	}
	
	@GetMapping(path="/log")
	public List<Transaction_Log> getTransactionalLog(){
		return service.getTransactionalLog();
	}
	
	
	
}
