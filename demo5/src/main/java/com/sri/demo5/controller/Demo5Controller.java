package com.sri.demo5.controller;

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo5Controller {
	
	@GetMapping("/login")
	
	public String sri(@RequestParam String username,@RequestParam String password)
	{
		if(username.equals("admin") && password.equals("12345"))
		{
			return "Login Successful";
		}
		else
		{
			return "Login Failed please check your username and password";
		}
	}

}