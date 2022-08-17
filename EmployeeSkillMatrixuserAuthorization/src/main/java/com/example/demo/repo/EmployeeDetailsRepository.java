package com.example.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.EmployeeDetails;


public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {

	@Query(value="select * from pavi_Employee_Details_2022 where emp_designation_id=:id", nativeQuery = true)
	public List<EmployeeDetails> findByDesignationId(@Param("id")int id);
	
	@Query(value="select * from pavi_Employee_Details_2022 where emp_name=:name", nativeQuery = true)
	public List<EmployeeDetails> findByEmpName(@Param("name")String name);
	
	@Query(value="select * from pavi_Employee_Details_2022 where emp_id=:id", nativeQuery = true)
	public EmployeeDetails findByEmpId(@Param("id")int id);
	
	
	@Query(value ="update pavi_Employee_Details_2022 set manager_name=:manager where emp_id=:empID",nativeQuery = true)
	@Modifying
	@Transactional
	public int updateEmployeeDetails(@Param("manager")String managername,@Param("empID") int empid); 

}
