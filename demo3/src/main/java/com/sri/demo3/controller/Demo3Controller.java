package com.sri.demo3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo3Controller {

	@GetMapping("/run")
	public String login()
	{
		return "Login Successfully";
	}
}
