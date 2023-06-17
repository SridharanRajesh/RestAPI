package com.sri.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Demo2Controller {

@GetMapping("/LandingPage")
	
	public String sri(@RequestParam String username)
	{
		return "Hello "+username;
	}
}
