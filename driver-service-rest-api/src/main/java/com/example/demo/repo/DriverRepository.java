package com.example.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Driver;


public interface DriverRepository extends JpaRepository<Driver,Integer> {
	
	List<Driver> findByDriverName(String srchName);
	
	// In the entity class there is no property firstName , so an exception will be thrown - no property
	//List<Driver> findByFirstName(String srchName);
	
	List<Driver> findByMobileNumber(long mobilenumber);
	
				// findByRating
	@Query(value = "From Driver where rating =:srchValue")
	List<Driver> searchByRating(@Param("srchValue") double rating);
	
	@Query(value = "update Driver set rating =:updatedRating where driverId=:srchId")
	@Modifying
	@Transactional
	int modifyRating(@Param("srchId") int driverId,@Param("updatedRating") double updatedRating);
	
}
