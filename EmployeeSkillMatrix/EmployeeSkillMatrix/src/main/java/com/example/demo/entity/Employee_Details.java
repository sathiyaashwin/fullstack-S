package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name ="emp_details_vnk")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Employee_Details {
	@Id
	@Column(name= "emp_id")
	private int empId; 
	
	@Column(name= "emp_name")
	private String empName;
	
	
	

	@Column(name="emp_designation_id")
	private int empDesginationId;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name= "emp_doj")
	private LocalDate empDoj;
	
	@Column(name="manager_name")
	private String manager;
}
