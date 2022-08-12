package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee_Designation;
import com.example.demo.repo.EmployeeDesignationRepo;

@Service
public class Employee_Desigination_Service {

	@Autowired
	public EmployeeDesignationRepo desigRepo;
	
	public List<Employee_Designation> getEmpDesig() {
		
		return this.desigRepo.findAll();
	}
	 public Employee_Designation addEmpDesig(Employee_Designation entity) {
			
			return this.desigRepo.save(entity);
		}
}
