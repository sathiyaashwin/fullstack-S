package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="pavi_employee_skills_2022")
public class EmployeeSkills {
	
	@Id
	@SequenceGenerator(name = "paviseq2", sequenceName = "paviseqgen2", initialValue = 101, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paviSeq2")
	@Column(name = "emp_skills_id")
    int empSkillsId ;
	
	@Column(name = "emp_id")
	int empId;
	
	@Column(name ="skill_id")
	int skillId;
	
	@Column(name = "skill_name")
	String skillName;
	
	@Column(name = "skill_experience")
	int skillExperience;
	
	@Column(name = "status")
	String status;

	@Column(name = "approved_by")
	String approvedBy;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "approved_date")
	LocalDate approvedDate;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "created_date")
	LocalDate createdDate;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "modified_date")
	LocalDate modifiedDate;
	
	@Column(name = "manager_id")
	int managerId;

}
