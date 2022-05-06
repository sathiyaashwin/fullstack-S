package com.training.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.training.Student;

public class StudentService {

	private List<Student> studentList;
	public StudentService() {
		super();
		this.studentList=new ArrayList<Student>();
	}
	
	public List<Student> getAll(){
		return this.studentList;
	}
	public Optional<Student> findById(int id) {
		return this.studentList
				.stream()
				.filter(e-> e.getRollNumber()==id)
				.findFirst();
	}
	public boolean remove(int id) {
		return this.studentList.removeIf(e->e.getRollNumber()==id);
	}
	
	public Student update(Student oldValue,Student newValue) {
		int index=this.studentList.indexOf(oldValue);
		return this.studentList.set(index, newValue);
		
	}
	public boolean add(Student student) {
		return this.studentList.add(student);
	}
	public Student update(int id,Student newValue) {
		
		int idxPos = this.studentList.indexOf(findById(id).get());
		
		return this.studentList.set(idxPos, newValue);
		
	}


}
