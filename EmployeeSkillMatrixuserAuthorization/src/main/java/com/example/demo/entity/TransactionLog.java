package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="pavi_transcation_log_2022")

public class TransactionLog {
	
	@Id
	@SequenceGenerator(name = "paviseq4", sequenceName = "paviseqgen4", initialValue = 101, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paviseq4")
	@Column(name = "transaction_id")
	private int transactionId ;
	
	@Column(name = "user_login_id")
	private int userLoginId ;
	
	@Column(name="api_operation_name")
	private String apiOperationName;
	
	@Column(name="request")
	private String request;
	
	@Column(name="response")
	private String response;
	
	@DateTimeFormat(iso = ISO.TIME)
	@Column(name="created_time")
	private LocalTime createdTime;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="created_date")
	private LocalDate createdDate;

}
