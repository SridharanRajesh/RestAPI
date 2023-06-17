package com.projectreview.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectreview.demo.model.loginPage;
import com.projectreview.demo.service.loginService;

@RestController
public class loginController {

	@Autowired
	loginService lser;
	
	@PostMapping("/checkLogin")
	public String validateUser(@RequestBody loginPage l)
	{
		System.out.println(l.getUsername());
		return lser.validateUser(l.getUsername(), l.getPassword());
	}
	
	@PostMapping("/addUser")
	public loginPage addDetails(@RequestBody loginPage l)
	{
		return lser.saveUser(l);
	}
}
