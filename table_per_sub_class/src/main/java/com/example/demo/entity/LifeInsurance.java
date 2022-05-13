package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "sat_life_ins")
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "policy_number")

public class LifeInsurance extends Insurance{
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "profile")
	private String profile;
	
	public LifeInsurance(int policynumber, String policyHolderName, int age, String profile) {
		super(policynumber, policyHolderName);
		this.age = age;
		this.profile = profile;
	}
	
	
	}
	
	


