package com.insta.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstaController {
	
	@GetMapping("/run")
	public String login()
	{
		return "Login Successfully";
	}
}
