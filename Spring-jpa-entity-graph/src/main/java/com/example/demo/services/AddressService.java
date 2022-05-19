package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.AddressRepository;
import com.example.demo.entity.Address;

@Service
public class AddressService {
	@Autowired
	private AddressRepository repo;
	
	public void task1() {
		List<Address> addressList = repo.findAll();
		
		for(Address eachaddres : addressList) {
			
			System.out.println(eachaddres.getCity());
			System.out.println(eachaddres.getUser());
			System.out.println(eachaddres.getTitle());
		}
	}
	public void task2() {
		List<Address> addressList = repo.findAll();
		
		for(Address eachaddres : addressList) {
			
			System.out.println(eachaddres.getCity());
			System.out.println(eachaddres.getUser());
			System.out.println(eachaddres.getTitle());
		}
	}
	public void task4() {
		List<Address> addressList = repo.findAll();
		
		for(Address eachaddres : addressList) {
			
			System.out.println(eachaddres.getTitle());
			System.out.println(eachaddres.getUser());
			
		}
	}
}
