package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetingController {
	    @GetMapping(path =  "/greet" )
	    
	    public String getMessage() {
	        return "Welcome! Token Based Authentication Working";
	    }

}
