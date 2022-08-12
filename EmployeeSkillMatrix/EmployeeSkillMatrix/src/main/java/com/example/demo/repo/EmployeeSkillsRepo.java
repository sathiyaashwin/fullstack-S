package com.example.demo.repo;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee_Skills;
import com.example.demo.entity.Skills_Reference;

@Repository
public interface EmployeeSkillsRepo extends JpaRepository<Employee_Skills, Integer> {
	
	//......
	@Query(value = "select * from employee_skills_vnk where skill_name=:name",nativeQuery = true)
	public List<Employee_Skills> srchByName(@Param("name") String skillName);
	//.....
	@Query(value = "select * from employee_skills_vnk where skill_experience=:experience",nativeQuery = true)
	public List<Employee_Skills> srchByexp(@Param("experience") String skillExperience);
	//...
	@Query(value="select es.* from emp_details_vnk ed,employee_skills_vnk es where ed.emp_id=es.emp_id and ed.emp_name=:empname",nativeQuery = true)
	List<Employee_Skills> srchByEmpName(@Param("empname") String empName);
	//......
	@Query(value ="select * from employee_skills_vnk where approved_by=:approvedby", nativeQuery = true)
	List<Employee_Skills> srchByApprovedBy(@Param("approvedby") String approvedby);

	@Query(value ="select * from employee_skills_vnk where status=:status and manager_id=:managerId", nativeQuery = true)
	List<Employee_Skills> srchByStatusAndManId(@Param("status")String status,@Param("managerId") int id);
	//.....
	@Query(value="select * from employee_skills_vnk where status=:status", nativeQuery = true)
	public List<Employee_Skills> srchByStatus(@Param("status")String status);
	//......
	@Query(value="select es.* from emp_details_vnk ed,employee_skills_vnk es where ed.emp_id=es.emp_id and ed.emp_name=:name and es.status=:status", nativeQuery = true)
	public List<Employee_Skills> srchByStatusAndEmpName(@Param("status")String status,@Param("name")String name);
	//.....
	@Query(value="select es.* from emp_details_vnk ed,employee_skills_vnk es where ed.emp_id=es.emp_id and ed.emp_name=:name and es.approved_by=:approvedby", nativeQuery = true)
	public List<Employee_Skills> srchByEmpNameAndAppBy(@Param("name")String name,@Param("approvedby")String approvedby);
	//....
	@Query(value="select es.* from emp_details_vnk ed,employee_skills_vnk es where ed.emp_id=es.emp_id and ed.emp_name=:name and es.approved_by=:approvedby and es.status=:status", nativeQuery = true)
	public List<Employee_Skills> srchByEmpNameAndAppByAndstatus(@Param("name")String name,@Param("approvedby")String approvedby,@Param("status")String status);
	//......
	@Query(value="select * from employee_skills_vnk where emp_id=:id", nativeQuery = true)
	public List<Employee_Skills> getByEmpId(@Param("id") int empId);
	
	//.......
	 @Query(value = "insert into employee_skills_vnk (approved_by,approved_date,created_date,emp_id,modified_date,skill_experience,skill_id,skill_name,status,manager_id,emp_skills_id) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,nextval('jtpsequence'))", nativeQuery = true)
	 @Transactional
	 @Modifying
	 public int insertEntity(String approvedBy,LocalDate approvedDate,LocalDate createdDate,int empId,LocalDate modifiedDate,String skillExp,int skillId,String skillName,String status,int managerId);
	 //.......
	 @Modifying
	 @Transactional
	 @Query(value ="update employee_skills_vnk  set status=:update,approved_date=:approvedate,approved_by=:approveby where status=:status and manager_id=:managerID",nativeQuery = true)
	 public int updateEntity(@Param("update")String update,@Param("status")String status,@Param("approvedate")LocalDate approvedate,@Param("approveby")String approveby,@Param("managerID") int id);
	//......	
	 @Query(value="select * from employee_skills_vnk where skill_name=:name and skill_experience=:experience", nativeQuery = true)
	 List<Employee_Skills> findBySkillNameAndSkillExperience(@Param("name")String skillName,@Param("experience") String skillExperience);
	 
//	 @Query(value="SELECT * FROM employee_skills_vnk WHERE (approved_by=:approvedby) OR (status=:status AND approved_by=:approvedby)", nativeQuery = true)
//	 List<Employee_Skills> findBasedOnThree(@Param("approvedby")String approvedby,@Param("status") String status);
	 //....
		@Query(value="select * from employee_skills_vnk where status=:status and approved_by=:approvedby", nativeQuery = true)
		public List<Employee_Skills> srchByStatusAndappBy(@Param("status")String status,@Param("approvedby")String appBy);
}


