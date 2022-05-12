package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeService {
	

	private EmployeeRepository repo;
	
	@Autowired
	public EmployeeService(EmployeeRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Employee add(Employee entity) 
	{
		return this.repo.save(entity);
	}
	
	public List<Employee> findAll()
	{
		return this.repo.findAll();
	}
	
	public List <Employee> findByLoc(String srch)
	{
		return this.repo.findByLocation(srch);
	} 
	
	public List <Employee> findBySkill(String srch)
	{
		return this.repo.findBySkillSet(srch);
	}
	
	public List<Employee> findBySkillSetLocation(@Param("skill") String skill,@Param("loc") String loc)
	{
		return this.repo.findBySkillLocation(skill,loc);
	}
	
	public List <Employee> findByDate(LocalDate date)
	{
		return this.repo.findByDateOfBirth(date);
	}
	

}
