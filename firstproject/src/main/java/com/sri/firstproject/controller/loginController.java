package com.sri.firstproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sri.firstproject.model.loginpage;
import com.sri.firstproject.service.loginService;

@RestController
public class loginController {

	@Autowired
		loginService lser;
		
		@PostMapping("/checkLogin")
		public String validateUser(@RequestBody loginpage l)
		{
			System.out.println(l.getUsername());
			return lser.validateUser(l.getUsername(), l.getPassword());
		}
		
		@PostMapping("/addUser")
		public loginpage addDetails(@RequestBody loginpage l)
		{
			return lser.saveUser(l);
		}
}
