package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.enitity.CabDriver;

@Repository
public interface CabDriverRepository extends JpaRepository<CabDriver,Integer> {

}
