package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "sathiyasem_one_to_one")
public class Seminar {
	
	@Id
	@Column(name = "seminar_id")
	int id;
	
	@Column(name = "seminar_name",length = 20,nullable = false)
	String name;
	
	@Column(name = "seminar_duration",nullable = false)
	int duration;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "speaker_ref")
	private Speaker speaker;

}
