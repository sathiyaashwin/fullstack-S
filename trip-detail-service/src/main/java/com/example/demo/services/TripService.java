package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TripDetail;
import com.example.demo.repository.TripRepository;

@Service
public class TripService {
	
	private TripRepository repo;
	
	@Autowired
	public TripService(TripRepository repo) {
		super();
		this.repo = repo;
	}
	
	public TripDetail save(TripDetail entity) {
		return repo.save(entity);
	}
	
	public List<TripDetail> findAll(){
		return repo.findAll();
	}
	
	public Optional<TripDetail> findById(int id) {
		return repo.findById(id);
	}
	
	public Optional<TripDetail> findByDriverId(int id){
		return repo.findByDriverId(id);
	}
	

}
