package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Sat_Doctor_Bi_Direction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
	
	@Id
	@Column(name = "doctor_id")
	int doctorId;
	
	@Column(name = "doctor_name")
	String doctorName;
	
	@Column(name = "department")
	String department;
	
	@Column(name = "phone_number")
	long phoneNumber;
	
	@OneToMany(targetEntity = Patient.class,fetch= FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "doctor")
	List<Patient> patientlist;

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", department=" + department
				+ ", phoneNumber=" + phoneNumber + "]";
	}	    
	
	

}