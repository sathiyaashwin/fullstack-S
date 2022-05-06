package com.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dateOfBirth = "1990-08-10";
		
		Student vicky = new Student();
		
		vicky.setRollNumber(200);
		vicky.setStudentName("Vignesh");
		vicky.setDateOfBirth(LocalDate.parse(dateOfBirth));
		vicky.setDateOfJoining(LocalDateTime.now());
		
		System.out.println("Year := "+vicky.getDateOfBirth().getYear());
		
		System.out.println("Month := "+vicky.getDateOfBirth().getMonth());
		
		System.out.println("Day := "+vicky.getDateOfBirth().getDayOfMonth());
		
		LocalTime startTime = LocalTime.of(9,30);
		
//		Duration duration = Duration.of(8,ChronoUnit.HOURS);
		
		LocalTime endTime = startTime.plusHours(8);		
		System.out.println("Start Time := "+startTime);
		System.out.println("End Time := "+endTime);

	}

}
