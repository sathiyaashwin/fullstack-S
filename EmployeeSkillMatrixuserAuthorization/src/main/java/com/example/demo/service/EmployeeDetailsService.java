package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeDetails;

import com.example.demo.entity.TransactionLog;
import com.example.demo.repo.EmployeeDetailsRepository;
import com.example.demo.repo.TransactionLogRepository;

@Service
public class EmployeeDetailsService {

		@Autowired
		public EmployeeDetailsRepository empRepo;
		
		@Autowired
		private TransactionLog transactionLog;
		
		@Autowired
		private TransactionLogRepository transactionLogRepo;
		
		
		//Method to Log Employee Details Request And its Response
		public TransactionLog transactionstatus(Object obj1,Object obj2) {
			
	        transactionLog.setApiOperationName("EmployeeDetails");
			transactionLog.setCreatedTime(LocalTime.now());
			
			transactionLog.setCreatedDate(LocalDate.now());
			
			transactionLog.setRequest(obj1.toString());
			
			transactionLog.setResponse(obj2.toString());
			return this.transactionLogRepo.save(transactionLog);
		}
		
	//Get All Employee Details
	 public List<EmployeeDetails> getEmpDetails() {
			
			return this.empRepo.findAll();
		}

	 //Insert Employee Details 
	 public EmployeeDetails add(Map<String,String> entity) {
		 EmployeeDetails empDetails = new EmployeeDetails();
		 if(Integer.parseInt(entity.get("empDesginationId"))==1001) 
		 {
		 empDetails.setEmpDesginationId(Integer.parseInt(entity.get("empDesginationId")));
		 empDetails.setEmpId(Integer.parseInt(entity.get("empId")));
		 empDetails.setEmpName(entity.get("empName"));
		 empDetails.setManager("MANAGER");
		 empDetails.setEmpDoj(LocalDate.parse(entity.get("empDoj")));
		 }else {
			 empDetails.setEmpDesginationId(Integer.parseInt(entity.get("empDesginationId")));
			 empDetails.setEmpId(Integer.parseInt(entity.get("empId")));
			 empDetails.setEmpName(entity.get("empName"));
			 empDetails.setManager("NA");
			 empDetails.setEmpDoj(LocalDate.parse(entity.get("empDoj")));
		 }
		return this.empRepo.save(empDetails);
	  }
	 
	 
	 public Object associateEmployees(Map<String,String> entity) {
		int count = 0;
		String manager = entity.get("Manager");
		List<String> emp = empRepo.findByDesignationId(101).stream().map(e->e.getEmpName()).collect(Collectors.toList());
		if(emp.contains(manager)) {
		List<String> keys = Arrays.asList(entity.get("EmpIDs").split(","));
		for(String id : keys) {
			 int val =empRepo.updateEmployeeDetails(manager,Integer.parseInt(id));
			 count=val++;
			 }
		
		return  count;
		}
		return "The entered Value is not of Manager";
		
	 }
	 
	 
	 // update 
	  public EmployeeDetails updateEmployee(EmployeeDetails entity) {
		
		return this.empRepo.save(entity);
	}
	}

