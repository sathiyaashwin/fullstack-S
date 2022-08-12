package com.example.demo.enitity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "Sath_Cab_Driver")

public class CabDriver {
	
	@Id
	@Column(name = "driver_Id")
	int driverId;
	
	@Column(name = "driver_Name")
	String driverName;
	
	@Column(name = "mobile_Number")
	long mobileNumber;
	
	@Column(name="date_Of_Birth")
	@DateTimeFormat(iso = ISO.DATE)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	LocalDate dateOfBirth;
	
	@Column(name = "rating")
	double rating;
	

}
