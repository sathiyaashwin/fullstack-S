package com.training;

import java.util.HashSet;
import java.util.Map;
import java.util.*;

import com.training.service.Doctor;
import com.training.service.Patient;

public class Application {

	public static void main(String[] args) {
		
		
		
		Patient patient1 = new Patient(101,"Gowsick","Avadi",7856778);
		Patient patient2 = new Patient(102,"Vishnu","Cmbt",5476778);
		Patient patient3 = new Patient(103,"Yovel","Siruseri",457757);
		Patient patient4 = new Patient(104,"location","Navalur",574456);
		
		Set<Patient> rampatients = new HashSet<>();
		
		rampatients.add(patient1);
		rampatients.add(patient2);
		rampatients.add(patient3);
		rampatients.add(patient4);
		
		Doctor ram = new Doctor(01,"ram","Heart_Doctor",rampatients);
		//Doctor doc1 = new Doctor(02,"ravi","Brain_Doctor",rampatients);
		
	
		
		
		System.out.println(ram.getDoctorname());
		for(Patient eachPatient: ram.getPatients()) {
			System.out.println(eachPatient);
		}
		
		Map<Doctor,Set<Patient>> map1=new HashMap<>();
		map1.put(ram,rampatients);
		//map1.put(doc1,rampatients);
		Appointment app=new Appointment(map1);
		
		System.out.println(app.getPatients(ram));

	}

}
