package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



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
@DiscriminatorValue(value = "LIFE")
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
	
	


