package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee_Designation;

public interface EmployeeDesignationRepo extends JpaRepository<Employee_Designation, Integer> {

}
