package com.example.demo.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver {

	
	int driverId;
	String driverName;
	long mobileNumber;
	double rating;
}
