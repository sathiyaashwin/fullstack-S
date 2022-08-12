package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="emp_desig_vnk")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee_Designation {

	
	
//	@SequenceGenerator(name = "vnkSeq", sequenceName = "vnkSeqGen", initialValue = 101, allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vnkSeq")
	@Column(name= "emp_designation_id")
	@Id
	private int designationId;
	
	@Column(name="emp_designation")
	private String empDesignation;
}
