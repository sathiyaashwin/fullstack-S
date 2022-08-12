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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction_log_vnk")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction_Log {


	@Id
	
	 @SequenceGenerator(name = "vnkSeq", sequenceName = "vnkSeqGen", initialValue = 101, allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vnkSeq")
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
