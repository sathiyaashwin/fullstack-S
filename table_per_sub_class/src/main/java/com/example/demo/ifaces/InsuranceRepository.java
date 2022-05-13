package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Insurance;

public interface InsuranceRepository<T extends Insurance> extends JpaRepository<T,Integer> {
	

}
