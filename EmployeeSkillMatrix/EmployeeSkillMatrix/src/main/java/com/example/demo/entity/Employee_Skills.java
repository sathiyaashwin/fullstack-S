package com.example.demo.entity;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employee_skills_vnk")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Employee_Skills {

	
	
	@Id
	@SequenceGenerator(name = "vnkSeq2", sequenceName = "jtpsequence", initialValue = 101, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vnkSeq2")
	@Column(name = "emp_skills_id")
	private int empSkillsId ;
	
	@Column(name="emp_id")
	
	private int empId;
	
	@Column(name="skill_id")
	private int skillId;
	
	@Column(name="skill_name")
	private String skillName;
	
	@Column(name="skill_experience")
	private String skillExperience;
	
	
	@Column(name="status")
	private String status;

	@Column(name="approved_by")
	private String approvedBy;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="approved_date")
	private LocalDate approvedDate;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="modified_date")
	private LocalDate modifiedDate;
	
	@Column(name="manager_id")
	private int managerId;
}