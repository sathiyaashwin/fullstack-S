package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Driver;
import com.example.demo.repo.DriverRepository;


@Service
public class DriverService {
	
	
	private DriverRepository repo;
	
	@Autowired
	public DriverService(DriverRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Driver> findAll() {
		return this.repo.findAll();
	}

	public Driver add(Driver entity) {
		return this.repo.save(entity);
	}

	public Driver findById(int id)
	{
		return this.repo.findById(id).orElseThrow(()->new RuntimeException(id+":- not found"));
	}



	public String delete(int id) {
		String message;
		try {
		 this.repo.deleteById(id);
		 message="One element deleted";
		 return message;
		 
		 
		} catch (Exception e) {
			e.printStackTrace();
			message="Not found";
		}
		return message;
	}
	public List<Driver> findByDriverName(String srchName){
		return this.repo.findByDriverName(srchName);
	}
	
	public List<Driver> findByMobileNumber(long mobilenumber){
		return this.repo.findByMobileNumber(mobilenumber);
	}
	
	public List<Driver> searchByRating(double rating){
		return this.repo.searchByRating(rating);
	}
	
	public int updateRating(int driverId, double updatedRating) {
		return this.repo.modifyRating(driverId, updatedRating);
	}
	
	public List<Driver> sortedList(String propName){
		return this.repo.findAll(Sort.by(propName));
	}
}


