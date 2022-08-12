package com.example.demo.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee_Details;
import com.example.demo.entity.Skills_Reference;
import com.example.demo.entity.Transaction_Log;
import com.example.demo.repo.EmployeeDetailsRepo;
import com.example.demo.repo.SkillReferenceRepo;
import com.example.demo.repo.TransactionRepo;

@Service
public class Skill_Reference_Service {
	
	@Autowired
	public EmployeeDetailsRepo empRepo;
	@Autowired
	public SkillReferenceRepo referRepo;
	@Autowired
	private Transaction_Log transaction;
	
	@Autowired
	private TransactionRepo repo;
	
	public void transactionstatus(Object obj1,Object obj2) {
        transaction.setApiOperationName("SkillReferenceController");
	    
		
		transaction.setCreatedTime(LocalTime.now());
		
		transaction.setCreatedDate(LocalDate.now());
		
		transaction.setRequest(obj1.toString());
		
		transaction.setResponse(obj2.toString());
		this.repo.save(transaction);
	}
	 public Object insert(Skills_Reference entity) {
		String createdBy = entity.getCreatedBy();
		Skills_Reference responce= null;
		List<String> managerNames =  empRepo.findByDesignationId(101)
				.stream().map(e-> e.getEmpName()).collect(Collectors.toList());
		
		try {
			if(managerNames.contains(createdBy)) {
				System.out.println(entity);
				responce=this.referRepo.save(entity);
				 return	responce;}
			else {
				return "Entered Name in the Created By is not of Manager";
			}
			}catch(Exception e) {
		return "skill Name Already Exist";	
		}
		
		}
		public List<Skills_Reference> skillList() {
			return this.referRepo.findAll();
			
		}
}
//public Object insert(Skills_Reference entity) {
//	String createdBy = entity.getCreatedBy();
//	Skills_Reference responce= null;
//	List<String> managerNames =  empRepo.findByDesignationId(101)
//			.stream().map(e-> e.getEmpName()).collect(Collectors.toList());
//	
//	try {
//		
//	for(Employee_Details each : emp) {
//		System.out.println(each);
//		if(createdBy.equals(each.getEmpName())) {
//			System.out.println(entity);
//			responce=this.referRepo.save(entity);
//			 return	responce;
//		}
//		
//	}}catch(Exception e) {
//	return "skill Name Already Exist";	
//	}
//	return null;
//	}
