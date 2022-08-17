package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SkillsReference;
import com.example.demo.entity.TransactionLog;
import com.example.demo.repo.EmployeeDetailsRepository;
import com.example.demo.repo.SkillReferenceRepository;
import com.example.demo.repo.TransactionLogRepository;


@Service
public class SkillReferenceService {
	
	@Autowired
	private EmployeeDetailsRepository empRepo;
	
	@Autowired
	private SkillReferenceRepository skillReferenceRepo;
	
	@Autowired
	private TransactionLog transactionLog;
	
	@Autowired
	private TransactionLogRepository transcationLogRepo;
	
	//transaction status
	public void transactionstatus(Object obj1,Object obj2) {
		
        transactionLog.setApiOperationName("SkillReferenceController");
	    
		transactionLog.setCreatedTime(LocalTime.now());
		
		transactionLog.setCreatedDate(LocalDate.now());
		
		transactionLog.setRequest(obj1.toString());
		
		transactionLog.setResponse(obj2.toString());
		
		this. transcationLogRepo.save(transactionLog);
	}
	
	//insert object
	 public Object insert(SkillsReference entity) {
		String createdBy = entity.getCreatedBy();
		SkillsReference responce= null;
		List<String> managerNames =  empRepo.findByDesignationId(101)
				.stream().map(e-> e.getEmpName()).collect(Collectors.toList());
		
		try {
			if(managerNames.contains(createdBy)) {
				System.out.println(entity);
				responce=this.skillReferenceRepo.save(entity);
				 return	responce;}
			else {
				return "Entered Name in the Created By is not of Manager";
			}
			}catch(Exception e) {
		return "skill Name Already Exist";	
		}
		
		//findAll
		}
		public List<SkillsReference> skillList() {
			return this.skillReferenceRepo.findAll();
			
		}

}
