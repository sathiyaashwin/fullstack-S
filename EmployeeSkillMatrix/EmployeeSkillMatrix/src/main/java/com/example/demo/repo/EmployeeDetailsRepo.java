package com.example.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Employee_Details;

public interface EmployeeDetailsRepo extends JpaRepository<Employee_Details, Integer> {
	
	@Query(value="select * from emp_details_vnk where emp_designation_id=:id", nativeQuery = true)
	public List<Employee_Details> findByDesignationId(@Param("id")int id);
	
	@Query(value="select * from emp_details_vnk where emp_name=:name", nativeQuery = true)
	public List<Employee_Details> findByEmpName(@Param("name")String name);
	
	@Query(value="select * from emp_details_vnk where emp_id=:id", nativeQuery = true)
	public Employee_Details findByEmpId(@Param("id")int id);
	
	
	@Query(value ="update emp_details_vnk   set manager_name=:manager where emp_id=:empID",nativeQuery = true)
	@Modifying
	@Transactional
	public int updateEmployeeDetails(@Param("manager")String managername,@Param("empID") int empid); 
	 
	 
}
