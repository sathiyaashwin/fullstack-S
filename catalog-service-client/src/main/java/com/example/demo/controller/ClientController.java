package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	
	@Autowired	private RestTemplate template;
	
	public String getCatalog()
	{
		return template.getForObject("http://localhost:7070/api/v1/catalogs", String.class);
	}
}
