package com.example.demo.repo;





import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	public List <Employee> findByLocation(String srch);
	public List <Employee> findBySkillSet(String srch);
	@Query(nativeQuery=true,value="select * from sathiyaa_Employee se where se.skill_set=:skillSet AND se.location=:loc") 
	public List<Employee> findBySkillLocation (@Param("skillSet") String skillSet,
	@Param("loc") String loc);
	public List <Employee> findByDateOfBirth(LocalDate date);

}
