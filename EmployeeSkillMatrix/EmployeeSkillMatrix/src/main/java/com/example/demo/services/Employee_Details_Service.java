package com.example.demo.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee_Details;
import com.example.demo.entity.Transaction_Log;
import com.example.demo.repo.EmployeeDetailsRepo;
import com.example.demo.repo.TransactionRepo;

/*Service Class For Employee Details.. with its logical function*/
@Service
public class Employee_Details_Service {

	@Autowired
	public EmployeeDetailsRepo empRepo;
	@Autowired
	private Transaction_Log transaction;
	
	@Autowired
	private TransactionRepo repo;
	
	
	
	
	/*Method to Log Employee Details Request And its Response*/
	public void transactionstatus(Object obj1,Object obj2) {
        transaction.setApiOperationName("EmployeeDetails");
		transaction.setCreatedTime(LocalTime.now());
		
		transaction.setCreatedDate(LocalDate.now());
		
		transaction.setRequest(obj1.toString());
		
		transaction.setResponse(obj2.toString());
		this.repo.save(transaction);
	}
	
/*Function for getting all Employee Details*/	
 public List<Employee_Details> getEmpDetails() {
		
		return this.empRepo.findAll();
	}

 /*Function to insert Employee Details */
 public Employee_Details add(Map<String,String> entity) {
	 Employee_Details empDetails = new Employee_Details();
	 if(Integer.parseInt(entity.get("empDesginationId"))==101) 
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
 /*Function To Perform update */
  public Employee_Details updateEmployee(Employee_Details entity) {
	
	return this.empRepo.save(entity);
}
}
