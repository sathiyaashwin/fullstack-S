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
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="skills_reference_vnk")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Skills_Reference {
	@Id
	
	 @SequenceGenerator(name = "vnkSeq", sequenceName = "vnkSeqGen", initialValue = 101, allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vnkSeq")
	@Column(name= "skill_id")
	private int skillId;
	@Column(name= "skill_type")
	private String skillType;
	
	
	@Column(name= "skill_name")
	private String skillName;
	@Column(name= "create_date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate createdDate;
	@Column(name= "created_by")
	private String createdBy;
	@DateTimeFormat(iso = ISO.TIME)
	@Column(name= "created_time")
	private LocalTime createdTime;
}
