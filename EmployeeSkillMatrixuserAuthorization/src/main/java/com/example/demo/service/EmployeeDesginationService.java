package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeDesignation;

import com.example.demo.repo.EmployeeDesignationRepository;

@Service
public class EmployeeDesginationService {
	
	@Autowired
	private EmployeeDesignationRepository designationRepo;
	
   public List<EmployeeDesignation> getEmpDesig() {
	   return this.designationRepo.findAll();
   }
   
	 public EmployeeDesignation addEmpDesig(EmployeeDesignation entity) {
			
			return this.designationRepo.save(entity);

}
}
