package com.sri.demo4.controller;

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Demo4Conroller {

	@GetMapping("/loginpage")
	public String login()
	{
		return "Login";
	}
	
	@GetMapping("/landingpage/{username}")
	public String landingpage(@PathVariable("username") String username)
	
	{
		return "Landingpage of the user is "+username ;
	}
}
