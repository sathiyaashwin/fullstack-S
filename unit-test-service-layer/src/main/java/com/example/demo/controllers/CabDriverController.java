package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enitity.CabDriver;
import com.example.demo.service.CabDriverService;

@RestController
@RequestMapping(path = "/api/v1/drivers")
@CrossOrigin(origins = "*")
public class CabDriverController {
	
	private CabDriverService service;

	public CabDriverController(CabDriverService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<CabDriver> add(@RequestBody CabDriver entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}
	
	@GetMapping (produces = "application/json")
	public List<CabDriver> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping(value = "/findById/{id}")
	public CabDriver findById(@PathVariable("id")int id){
		return this.service.findById(id).get();
	}
	
	@DeleteMapping(value = "/deleteById/{id}")
	public void remove(@PathVariable("id")int id) {
			this.service.remove(id);
	}

}
