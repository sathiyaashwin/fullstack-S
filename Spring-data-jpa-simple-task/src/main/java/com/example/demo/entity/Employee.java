package com.example.demo.entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sathiyaa_Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
		@Id
		@Column(name = "empolyee_id")
		int employeeId;
		
		@Column(name = "empolyee_name")
		String employeeName;
		
		@Column(name = "date_of_birth")
		LocalDate dateOfBirth;
		
		@Column(name = "location")
		String location;
		
		@Column(name = "skill_set")
		String skillSet;
		
		@Column(name = "phone_number")
		long phoneNumber;
	}

