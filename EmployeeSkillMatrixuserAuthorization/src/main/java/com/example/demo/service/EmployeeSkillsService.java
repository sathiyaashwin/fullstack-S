package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeDetails;
import com.example.demo.entity.EmployeeSkills;
import com.example.demo.entity.SkillsReference;
import com.example.demo.entity.TransactionLog;
import com.example.demo.repo.EmployeeDetailsRepository;
import com.example.demo.repo.EmployeeSkillRepository;

import com.example.demo.repo.SkillReferenceRepository;
import com.example.demo.repo.TransactionLogRepository;

@Service
public class EmployeeSkillsService {
	@Autowired
	private EmployeeDetailsRepository empRepo;
	
	@Autowired
	private EmployeeSkillRepository skillRepo;
	
	@Autowired
	private SkillReferenceRepository skillReferenceRepo;
	
//	@Autowired
//	private EmployeeSkills empSkill;
//	
	@Autowired
	private TransactionLog transaction;
	
	@Autowired
	private TransactionLogRepository transactionRepo;
	
	public void transactionstatus(Object obj1,Object obj2) {
        transaction.setApiOperationName("Employee_Skill_Service");
	    
		
		transaction.setCreatedTime(LocalTime.now());
		
		transaction.setCreatedDate(LocalDate.now());
		
		transaction.setRequest(obj1.toString());
		
		transaction.setResponse(obj2.toString());
		this.transactionRepo.save(transaction);
	}

	
public List<EmployeeSkills> getEmployeeSkills(){
	
	return this.skillRepo.findAll();
	}
public List<TransactionLog> getTransactionalLog(){
	
	return this.transactionRepo.findAll();
	}

public Object getEmployeeSkills(String empName){
	List<EmployeeDetails> emp =  empRepo.findByDesignationId(101);
	List<EmployeeSkills> responce =null;

	for(EmployeeDetails each : emp) {
		
		if(empName.equals(each.getEmpName())) {
			
			responce=this.skillRepo.srchByStatusAndManId("DRAFT",each.getEmpId());
			 return	responce;
		}
	}
		return empName + "Is not of Manager";
	
	
	}
public EmployeeSkills update(EmployeeSkills entity) {
	return this.skillRepo.save(entity);
}
public Object add(Map<String,String> entity) {
	int id = Integer.parseInt(entity.get("empId"));
 String skillName =entity.get("skillName");	
SkillsReference ref = skillReferenceRepo.findBySkillName(skillName);
if(ref==null) {
	return "Skill Name is not Present in the skill Reference";
}

EmployeeDetails details = empRepo.findByEmpId(id);
 
if(details==null) {
	return "Employee Id is Not Present";
}

List<Integer>  managerId = empRepo.findByEmpName(details.getManager()).stream().map(e->e.getEmpId()).collect(Collectors.toList());
List<EmployeeSkills> skills = skillRepo.getByEmpId(id);
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
	List<EmployeeDetails> emp =  empRepo.findByDesignationId(101);

	List<Map<String,Object>> skillSet = new LinkedList<>();
	
	
	for(EmployeeDetails each : emp) {
		if(empName.equals(each.getEmpName())) {
			this.skillRepo.updateEntity(status, "DRAFT",LocalDate.now(),empName,each.getEmpId());
			List<EmployeeSkills>	skills = this.skillRepo.srchByStatus("APPROVED");
			for(EmployeeSkills skill: skills) {
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

	public EmployeeSkills updateSkills(EmployeeSkills entity) {

	return this.skillRepo.save(entity);
	}

}
