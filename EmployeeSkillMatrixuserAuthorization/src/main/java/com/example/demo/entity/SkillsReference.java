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
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="pavi_skill_reference_2022")
public class SkillsReference {
	
	@Id
	@SequenceGenerator(name = "paviSeq", sequenceName = "paviSeqGen", initialValue = 101, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paviSeq")
	@Column(name= "skill_id")
	int skillId;
	
	@Column(name= "skill_type")
    String skillType;
	
	@Column(name= "skill_name")
	private String skillName;
	
	@Column(name= "create_date")
	@DateTimeFormat(iso = ISO.DATE)
    LocalDate createdDate;
	
	@Column(name= "created_by")
    String createdBy;
	
	@DateTimeFormat(iso = ISO.TIME)
	@Column(name= "created_time")
    LocalTime createdTime;

}
