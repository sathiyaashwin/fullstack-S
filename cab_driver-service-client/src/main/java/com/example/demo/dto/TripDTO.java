package com.example.demo.dto;


import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.enitity.CabDriver;
import com.example.demo.enitity.TripDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
public class TripDTO {
	
	private CabDriver driver;
	private List<TripDetail> trip;

}
