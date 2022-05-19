package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Passenger;
import com.example.demo.repo.PassengerRepository;

@Service
public class PassengerService {
	
private PassengerRepository repo;
	
	@Autowired
	public PassengerService(PassengerRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Passenger> findAll() {
		
		return this.repo.findAll();
	}

	public Passenger findById(int id) {
		
		return this.repo.getById(id);
	}

	public Passenger add(Passenger entity) {
	
		return this.repo.save(entity);
	}
	
	public List<Passenger> getByPassengerName(@Param("passName") String passName)
	{
	return this.repo.getByPassengerName(passName);
	}
//	public List<Passenger>getByPassengerDateTime(@Param("dateTime") LocalDateTime dateTime)
//	{
//	return this.repo.getByPassengerDateTime(dateTime);
//	}
	public List<Passenger> srchByTripDateTime(LocalDateTime tripDate) {
		return this.repo.findByTripListTripDateTime(tripDate);
	}
	

}
