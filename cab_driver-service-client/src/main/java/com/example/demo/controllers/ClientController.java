package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.TripDTO;
import com.example.demo.enitity.CabDriver;
import com.example.demo.enitity.TripDetail;

@RestController
@RequestMapping(path = "/client")
public class ClientController {
	
	@Autowired
	private TripDTO dto;
	

	private RestTemplate template;
	
	@Autowired
	public ClientController(RestTemplate template) {
		super();
		this.template = template;
	}
	
	@GetMapping(value = "/drivers")
	public String getDrivers()
	{
		return this.template.getForObject("http://cab-driver-service/api/v1/drivers", String.class);
	}
	@GetMapping(path = "/trips/json")
	public TripDetail[] getTrips() 
	{
		return this.template.getForObject("http://trip-detail-service/api/v1/trips",TripDetail[].class);
	}
	@GetMapping(path = "/drivers/json")
	public CabDriver[] getDriversAsJson() 
	{
		return this.template.getForObject("http://cab-driver-service/api/v1/drivers",CabDriver[].class);
	}
	
	@GetMapping(path = "/drivers/trips/{id}")
	public String getDriverTrips(@PathVariable("id") int id ) 
	{
		String driver=this.template.getForObject("http://cab-driver-service/api/v1/drivers/findById/"+id,String.class);
		String trip= this.template.getForObject("http://trip-detail-service/api/v1/trips/driverId/"+id,String.class);
	    return driver+trip;
	}
	
	@GetMapping(path = "/drivers/trips/json/{id}")
	public TripDTO getDriverTripsAsJson(@PathVariable("id") int id ) 
	{
		CabDriver driver=this.template.getForObject("http://cab-driver-service/api/v1/drivers/findById/"+id,CabDriver.class);
		TripDetail[] trip= this.template.getForObject("http://trip-detail-service/api/v1/trips/driverId/"+id,TripDetail[].class);
		dto.setDriver(driver);
		List<TripDetail> detail = Arrays.asList(trip);
		dto.setTrip(detail);
		
		return dto;
	}
	
}
