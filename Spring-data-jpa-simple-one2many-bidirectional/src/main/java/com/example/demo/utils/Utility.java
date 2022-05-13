package com.example.demo.utils;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.ifaces.bidirectional.DoctorRepository;
import com.example.demo.ifaces.bidirectional.PatientRepository;

@Component
public class Utility {
	
	@Autowired
	List<Patient> patientList ;
	
	@Autowired
	Doctor doc;
	
	@Autowired
	DoctorRepository doctorRepo;
	
	@Autowired
	PatientRepository patientRepo;
	
	
	public void create()
	{
		for(Patient eachPatient: patientList) {
			eachPatient.setDoctor(doc);
			patientRepo.save(eachPatient);
		}

		Doctor added=doctorRepo.save(doc);
		if(added!=null)
		{
			System.out.println("One Record Added");
		}
	}

	public void findAll() {
		
		List<Doctor> doctors = doctorRepo.findAll();
		
		for(Doctor eachDoctor:doctors) {
			System.out.println(("Doctor Name:- "+eachDoctor.getDoctorName()));
			System.out.println(("Departement:- "+eachDoctor.getDepartment()));
			
			List<Patient> patients = eachDoctor.getPatientlist();
			for(Patient eachPatient: patients) {
				
				System.out.println("Patient Name:- "+eachPatient.getPatientName());
				System.out.println("Mobile number:- "+eachPatient.getMobileNumber());
			}
		}
}
	
		public void findDoctorFromPatient() {
			
			Patient entity= patientRepo.findById(301).get();
			System.out.println(entity.getPatientName());
			System.out.println(entity.getDoctor());
		}

}

