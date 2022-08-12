package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Transaction_Log;

public interface TransactionRepo extends JpaRepository<Transaction_Log, Integer> {

}
