package com.example.demo.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
	
	//public List<Passenger> findByPassengerName(String passName);
	@Query(nativeQuery=true,value="select * from sathiya_passenger  where passenger_name=:passName ") 
	public List<Passenger> getByPassengerName (@Param("passName") String passName);
	
	//@Query(nativeQuery=true,value="select * from sathiya_passenger  where trip_date_time=:dateTime ") 
	//public List<Passenger> getByPassengerDateTime(@Param("dateTime") LocalDateTime dateTime);

	public List<Passenger> findByTripListTripDateTime(LocalDateTime tripDate);
}
