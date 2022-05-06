package com.example.demo.model;

import java.util.List;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@AllArgsConstructor
@Getter

public class CustomerList {
	
	List<Customer> custList;

}
