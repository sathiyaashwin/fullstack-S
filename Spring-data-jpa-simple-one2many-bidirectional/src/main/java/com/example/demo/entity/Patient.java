package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Sat_Patient_Bi_Diection")
@Getter
@Setter
@Data
@NoArgsConstructor
public class Patient {
	
	@Id
	@Column(name = "patient_id")
	int patientId;
	
	@Column(name = "patient_name")
	String patientName;
	
	@Column(name = "mobile_number")
	long mobileNumber;

	public Patient(int patientId, String patientName, long mobileNumber) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.mobileNumber = mobileNumber;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="doctor_ref", referencedColumnName = "doctor_id")
	private Doctor doctor;

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", mobileNumber=" + mobileNumber
				+ ", doctor=" + doctor + "]";
	}
	
	
	
}

