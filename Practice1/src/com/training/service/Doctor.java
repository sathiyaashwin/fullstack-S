package com.training.service;

import java.util.Set;

public class Doctor {
	
	private int doctorId;
	private String doctorname;
	private String department;
	private Set<Patient> patients;
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Doctor(int doctorId, String doctorname, String department) {
		super();
		this.doctorId = doctorId;
		this.doctorname = doctorname;
		this.department = department;
	}
	public Set<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(int doctorId, String doctorname, String department, Set<Patient> patients) {
		super();
		this.doctorId = doctorId;
		this.doctorname = doctorname;
		this.department = department;
		this.patients = patients;
	}
	
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorname=" + doctorname + ", department=" + department
				+ ", patients=" + patients + "]";
	}
	
}
