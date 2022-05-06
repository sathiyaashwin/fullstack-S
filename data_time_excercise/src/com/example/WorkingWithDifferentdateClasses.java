package com.example;

import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.time.*;

public class WorkingWithDifferentdateClasses {

	public static void main(String[] args) {
		
		// Step-1 Creating UTIL Date
		java.util.Date date1 = new java.util.Date();
		System.out.println(date1.getTime());
		System.out.println(date1);
		
		// Step-2 UTIL Date to SQL Date 
		java.sql.Date date2 = new java.sql.Date(date1.getTime());
		System.out.println(date2);
		
		// Step-3 SQL Date to LocalDate
		LocalDate localDate = date2.toLocalDate();	
		System.out.println(localDate.getDayOfWeek());
		System.out.println(localDate.getMonthValue());
		
		// Step-4 Local Date to SQL Date
		java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
		System.out.println("SQL Date 2:= "+ sqlDate);
	}
}
