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

import com.example.demo.entity.EmployeeSkills;
import com.example.demo.entity.TransactionLog;
import com.example.demo.service.EmployeeSkillsService;


@RestController
@RequestMapping(path = "api/v1")
public class EmployeeSkillController {
	
	@Autowired
	private EmployeeSkillsService skillService;
	
	
	@GetMapping(path = "/empskills")
	public List<EmployeeSkills> getUser() {
		List<EmployeeSkills>  list = skillService.getEmployeeSkills();
		skillService.transactionstatus(" ","A Count Of"+ list.size()+" Employee Skills Has Been Retrieved From DB");
		return skillService.getEmployeeSkills();	
	}
	
	
	@PostMapping(path = "/empskills")
	public Object addEmployeeSkills(@RequestBody Map<String,String> empSkills) {
		Object emp=	skillService.add(empSkills);
		skillService.transactionstatus(empSkills,emp);
		return emp;
	}
	
	
	@PutMapping(path = "/empskills")
	public EmployeeSkills updateEmployeeSkills(@RequestBody EmployeeSkills empSkills) {
		return skillService.update(empSkills);
	}
	
	
	@GetMapping(path = "/manager/{empName}")
	public Object getEmployeeSkills(@PathVariable("empName") String empName) {
		Object list =skillService.getEmployeeSkills(empName);
		skillService.transactionstatus("Retrieving Employee Skills Who is associated with MANAGER: "+empName, list);
		return skillService.getEmployeeSkills(empName);	
	}
	
	
	@GetMapping(path = "/skillApproval")
	public Object getApprovedStatus(@RequestParam(value = "EmployeeName", required = true) String empName,@RequestParam(value = "Status", required = true) String status){
		Object list = skillService.getDraftStatus(empName, status);
		skillService.transactionstatus("Employee:"+ empName +" And Status: "+ status, list);
		return skillService.getDraftStatus(empName, status); 
	}
	

	@GetMapping(path="/search")
	public Object getEmpSkillsBasedOnInput(@RequestBody Map<String,String> search) {
		Object responce =skillService.srcByskills(search);
		skillService.transactionstatus(search, responce);
		return skillService.srcByskills(search);
	}
	
	
	@GetMapping(path="/searchInput")
	public Object getEmpSkillsBasedOnKeys(@RequestBody Map<String,String> search) {
		Object responce = skillService.srcByInput(search);
		skillService.transactionstatus(search, responce);
		return skillService.srcByInput(search);
	}
	
	
	@GetMapping(path="/log")
	public List<TransactionLog> getTransactionalLog(){
		return skillService.getTransactionalLog();
	}

}
