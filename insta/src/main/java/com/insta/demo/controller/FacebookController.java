package com.insta.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FacebookController {
	
	@GetMapping("/LandingPage")
	
	public String sri(@RequestParam String username)
	{
		return "Hello "+username;
	}
}
