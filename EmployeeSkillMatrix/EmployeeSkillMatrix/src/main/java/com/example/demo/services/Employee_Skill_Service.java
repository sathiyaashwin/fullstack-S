package com.example.demo.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee_Details;
import com.example.demo.entity.Employee_Skills;
import com.example.demo.entity.Skills_Reference;
import com.example.demo.entity.Transaction_Log;
import com.example.demo.repo.EmployeeDetailsRepo;
import com.example.demo.repo.EmployeeSkillsRepo;
import com.example.demo.repo.SkillReferenceRepo;
import com.example.demo.repo.TransactionRepo;

@Service
public class Employee_Skill_Service {
	@Autowired
	public EmployeeDetailsRepo empRepo;
	@Autowired
	public EmployeeSkillsRepo skillRepo;
	@Autowired
	public SkillReferenceRepo repo;
	@Autowired
	public Employee_Skills skill;
	@Autowired
	private Transaction_Log transaction;
	
	@Autowired
	private TransactionRepo repo1;
	
	public void transactionstatus(Object obj1,Object obj2) {
        transaction.setApiOperationName("Employee_Skill_Service");
	    
		
		transaction.setCreatedTime(LocalTime.now());
		
		transaction.setCreatedDate(LocalDate.now());
		
		transaction.setRequest(obj1.toString());
		
		transaction.setResponse(obj2.toString());
		this.repo1.save(transaction);
	}

	
public List<Employee_Skills> getEmployeeSkills(){
	
	return this.skillRepo.findAll();
	}
public List<Transaction_Log> getTransactionalLog(){
	
	return this.repo1.findAll();
	}

public Object getEmployeeSkills(String empName){
	List<Employee_Details> emp =  empRepo.findByDesignationId(101);
	List<Employee_Skills> responce =null;

	for(Employee_Details each : emp) {
		
		if(empName.equals(each.getEmpName())) {
			
			responce=this.skillRepo.srchByStatusAndManId("DRAFT",each.getEmpId());
			 return	responce;
		}
	}
		return empName + "Is not of Manager";
	
	
	}
public Employee_Skills update(Employee_Skills entity) {
	return this.skillRepo.save(entity);
}
public Object add(Map<String,String> entity) {
	int id = Integer.parseInt(entity.get("empId"));
 String skillName =entity.get("skillName");	
Skills_Reference ref = repo.findByName(skillName);
if(ref==null) {
	return "Skill Name is not Present in the skill Reference";
}

Employee_Details details = empRepo.findByEmpId(id);
 
if(details==null) {
	return "Employee Id is Not Present";
}

List<Integer>  managerId = empRepo.findByEmpName(details.getManager()).stream().map(e->e.getEmpId()).collect(Collectors.toList());
List<Employee_Skills> skills = skillRepo.getByEmpId(id);
if(skillName.equals(ref.getSkillName())) {
List<String> names = skills.stream().map(r->r.getSkillName()).collect(Collectors.toList());
if(!names.contains(skillName)&&managerId.get(0)==101) {
		int status =skillRepo.insertEntity("NA",
				LocalDate.of(0001,01,01),
				LocalDate.now(), id,
				LocalDate.now(), 
				entity.get("skillExperience"),
				ref.getSkillId(), skillName, "DRAFT",managerId.get(0));
		if(status==1) {
			return entity;
		}
		}
	}
	
return "Skill Name already present for That Employee";
	
}
public Object getDraftStatus(String empName,String status) {
	List<Employee_Details> emp =  empRepo.findByDesignationId(101);

	List<Map<String,Object>> skillSet = new LinkedList<>();
	
	
	for(Employee_Details each : emp) {
		if(empName.equals(each.getEmpName())) {
			this.skillRepo.updateEntity(status, "DRAFT",LocalDate.now(),empName,each.getEmpId());
			List<Employee_Skills>	skills = this.skillRepo.srchByStatus("APPROVED");
			for(Employee_Skills skill: skills) {
				Map<String,Object> responce = new LinkedHashMap<String, Object>();
				responce.put("EmpId",skill.getEmpId());
				responce.put("Skill Set",skill.getSkillName());
				responce.put("Status",skill.getStatus());
				
				skillSet.add(responce);
			}
			return skillSet;
		}
		
		}

	return "Entered Employee Name is not a Employee With Desigination As Manager";
}



public Object srcByskills(Map<String,String> search) {
	Collection<String> keys =search.keySet();
	try {
	if(keys.contains("skillName")&& keys.contains("skillExperience")) {
		return skillRepo.findBySkillNameAndSkillExperience(search.get("skillName"),search.get("skillExperience"));
	}else if(keys.contains("skillName")) {
		return skillRepo.srchByName(search.get("skillName"));
	}else if(keys.contains("skillExperience")) {
		return skillRepo.srchByexp(search.get("skillExperience"));
	}}catch(NullPointerException e) {
		return "Atleast One query should be filled";
	}
	return "To perform Operation need atleast one query";
}
public Object srcByInput(Map<String,String> search) {
	Collection<String> keys =search.keySet();
	try {
	if(keys.contains("empName")&&!keys.contains("approvedBy")&&!keys.contains("status"))
	{
		return skillRepo.srchByEmpName(search.get("empName"));
		}
	else if(keys.contains("approvedBy")&&!keys.contains("empName")&&!keys.contains("status"))
	{
		return skillRepo.srchByApprovedBy(search.get("approvedBy"));
	}
	else if( keys.contains("empName")&&keys.contains("status")&&!keys.contains("approvedBy"))
	{
		return skillRepo.srchByStatusAndEmpName(search.get("status"),search.get("empName"));
			}
	else if(keys.contains("status")&&keys.contains("approvedBy")&&!keys.contains("empName"))
	{
		return skillRepo.srchByStatusAndappBy(search.get("status"),search.get("approvedBy"));
	}
	else if(keys.contains("empName")&&keys.contains("approvedBy")&&!keys.contains("status"))
	{
		return skillRepo.srchByEmpNameAndAppBy(search.get("empName"), search.get("approvedBy"));
	}else if(keys.contains("empName")&&keys.contains("approvedBy")&&keys.contains("status")) {
		return skillRepo.srchByEmpNameAndAppByAndstatus(search.get("empName"), search.get("approvedBy"),search.get("status"));
	}
	else if(keys.contains("status"))
	{
		return skillRepo.srchByStatus(search.get("status"));
	}}catch(NullPointerException e) {
		return "Atleast One query should be filled";
	}
	
	return "To perform Operation need atleast one query";
}

	public Employee_Skills updateSkills(Employee_Skills entity) {

	return this.skillRepo.save(entity);
	}
	 


}
//public Object add(Map<String,String> entity) {
//
//	 String skillName =entity.get("skillName");	
//	List<Skills_Reference> ref = repo.findByName(skillName);
//	int id = Integer.parseInt(entity.get("empId"));
//	List<Employee_Skills> skills = skillRepo.getByEmpId(id);
//	Employee_Details details = empRepo.findByEmpId(id);
//	List<Integer>  managerId = empRepo.findByEmpName(details.getManager()).stream().map(e->e.getEmpId()).collect(Collectors.toList());
//		
//
//	for(Skills_Reference each: ref) {
//
//	if(skillName.equals(each.getSkillName())) {
//
//		
//		System.out.println(skills);
//		List<String> names = skills.stream().map(r->r.getSkillName()).collect(Collectors.toList());
//		List<Integer> ids = ref.stream().map(r->r.getSkillId()).collect(Collectors.toList());
//
//		if(!names.contains(skillName)) {
//			int status =skillRepo.insertEntity("NA",
//					LocalDate.of(0001,01,01),
//					LocalDate.now(), id,
//					LocalDate.now(), 
//					entity.get("skillExperience"),
//					ids.get(0), skillName, "DRAFT",managerId.get(0));
//			if(status==1) {
//				return entity;
//			}}
//		}
//	}	
//	return "Skill Name Or Employee Id May Not Present or skill Name already present";
//
//	}
