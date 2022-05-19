package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {

}
