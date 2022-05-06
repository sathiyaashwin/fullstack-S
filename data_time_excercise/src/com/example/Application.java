package com.example;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student ram = new Student(101,"ram",
									LocalDate.of(1972, 10, 12),
									LocalDateTime.of(2000,Month.JUNE,5,9,30));
		
		Student shyam = new Student(101,"Shyam",
									LocalDate.now(),
									LocalDateTime.now());
		
		System.out.println("Ram's Year of Birth "+ram.getDateOfBirth().getYear());
		
		System.out.println("Ram's First Birthday "+ram.getDateOfBirth().plus(1,ChronoUnit.YEARS));
		
		System.out.println("Shyam's Year of Birth "+shyam.getDateOfBirth().getYear());
		
		System.out.println("Shyam's 60th Birthday "+shyam.getDateOfBirth().plus(60,ChronoUnit.YEARS));
		
		System.out.println("Shyam's Previous Birthday "+shyam.getDateOfBirth().minus(2,ChronoUnit.YEARS));

		System.out.println("Shyam's  Birthday after 2 months "+shyam.getDateOfBirth().plus(2,ChronoUnit.MONTHS));

	}

}
