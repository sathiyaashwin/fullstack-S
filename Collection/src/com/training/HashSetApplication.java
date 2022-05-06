package com.training;

import com.training.model.Student;
import java.util.*;

public class HashSetApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student ram = new Student(101,"ram",78);
		Student shyam = new Student(102,"shayam",68);
		Student vishnu = new Student(103,"vishnu",88);
		Student Gvishnu = new Student(103,"vishnu",88);
		
		Set<Student> set = new TreeSet<>();
		
		set.add(ram);
		set.add(shyam);
		set.add(vishnu);
		set.add(Gvishnu);
		
		System.out.println(set);
		
		System.out.println(set.size());
		
		for(Student eachStudent : set) {
			System.out.println(eachStudent.getFirstName());
		}

	}

}
