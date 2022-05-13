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
@Table(name = "sat_health_ins")
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "policy_number")

public class HealthInsurance extends Insurance{
		
		@Column(name = "age")
		private int age;
		
		@Column(name = "status")
		private String status;
		
		public HealthInsurance(int policynumber, String policyHolderName, int age, String status) {
			super(policynumber, policyHolderName);
			this.age = age;
			this.status = status;
		}
		
		
}
