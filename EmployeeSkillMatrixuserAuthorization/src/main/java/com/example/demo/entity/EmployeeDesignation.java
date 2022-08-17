package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="pavi_employee_designation_2022")

public class EmployeeDesignation {
	
	@SequenceGenerator(name = "paviseq3", sequenceName = "paviSeqGen", initialValue = 101, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paviseq3")
	@Column(name= "emp_designation_id")
	@Id
	int designationId;
	
	@Column(name="emp_designation")
    String empDesignation;

}
