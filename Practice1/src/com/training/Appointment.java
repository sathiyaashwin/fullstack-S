package com.training;

import java.util.*;

import com.training.service.Doctor;
import com.training.service.Patient;

public class Appointment {
	 
	private Map<Doctor, Set<Patient>> List;

	public Map<Doctor, Set<Patient>> getList() {
		return List;
	}

	public void setList(Map<Doctor, Set<Patient>> list) {
		this.List = list;
	}

	public Appointment() {
		super();
		List = new HashMap<>();
	}

	public Appointment(Map<Doctor, Set<Patient>> list) {
		super();
		this.List = list;
	}

	@Override
	public String toString() {
		return "Appointment [List=" + List + "]";
	}
	public Set<Patient> getPatients(Doctor key)
	{
		return this.List.get(key);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	map.
//	map.put(2,patient2);
//	map.put(3,patient3);
//	map.put(4,patient4);
//	
//	Doctor doc = new Doctor(01,"ram","Heart_Doctor",map);
//	Doctor doc1 = new Doctor(02,"ravi","Brain_Doctor",map);
//	System.out.println(doc.getDoctorname());
//	
//	Set<Map.Entry<Integer,Patient>> appoint = map.entrySet();
//	
//	for(Map.Entry<Integer, Patient> eachpat : appoint ) {
//		System.out.println(eachpat.getKey());
//		System.out.println(eachpat.getValue());
		
	
	}

