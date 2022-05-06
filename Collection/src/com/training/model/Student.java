package com.training.model;

public class Student implements Comparable<Student> {
	
	private int rollNumber;
	private String firstName;
	private int markScored;
	
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getMarkScored() {
		return markScored;
	}
	public void setMarkScored(int markScored) {
		this.markScored = markScored;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int rollNumber, String firstName, int markScored) {
		super();
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.markScored = markScored;
	}
	
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", firstName=" + firstName + ", markScored=" + markScored + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + markScored;
		result = prime * result + rollNumber;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (markScored != other.markScored)
			return false;
		if (rollNumber != other.rollNumber)
			return false;
		return true;
	}
	@Override
	public int compareTo(Student otherObj) {
		// TODO Auto-generated method stub
		return this.firstName.compareTo(otherObj.firstName);
	}
}
