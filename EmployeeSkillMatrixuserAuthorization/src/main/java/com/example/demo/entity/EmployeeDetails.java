package com.example.demo.entity;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="pavi_Employee_Details_2022")

public class EmployeeDetails {
	
	@Id
	@Column(name= "emp_id")
	int empId; 
	
	@Column(name= "emp_name")
	String empName;
	
	@Column(name="emp_designation_id")
    int empDesginationId;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name= "emp_doj")
    LocalDate empDoj;
	
	@Column(name="manager_name")
    String manager;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "emp_designation_id")
//	private EmployeeDesignation designation;
}
