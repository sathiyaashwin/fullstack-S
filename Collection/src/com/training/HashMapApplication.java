package com.training;

import java.util.HashMap;

import com.training.model.Student;

public class HashMapApplication {

	public static void main(String[] args) {
		 
		Student ram = new Student (101, "anand", 78);

		Student shyam = new Student (102, "basky", 68);

		Student mukesh = new Student (103, "mukesh", 78); 

	

		HashMap<Integer, Student> map= new HashMap<>();

	

		System.out.println(map.put(900, ram));

		System.out.println(map.put(902, shyam));
		Student added =map.put(902, mukesh);
		
		if(added!=null) {
			map.put(904, added);
		}
		System.out.println(map.get(902));
		System.out.println(map.get(904));
		
	}
}