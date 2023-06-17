package com.sri.educationloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.educationloan.model.LoanApplicationModel;
import com.sri.educationloan.model.UserModel;
import com.sri.educationloan.service.UserService;

@RestController
@RequestMapping("/user")

public class UserController {

		@Autowired
		UserService userSer;
		@PostMapping("/login")
		public String validateUser(@RequestBody UserModel u)
		{
			return userSer.valideteUser(u.getEmail(), u.getPassword());
		}
		
		@PostMapping("/signup")
		public UserModel addDetails(@RequestBody UserModel u)
		{
			return userSer.saveUser(u);
		}
		@GetMapping(value="/getProfile")
		public List<UserModel> get()
		{
			List<UserModel> s=userSer.get();
			return s;
		}
		@GetMapping(value="/viewLoan/{user}")
		public LoanApplicationModel getById(@PathVariable int user)
		{
			LoanApplicationModel gbi=userSer.getById(user);
			return gbi;
		}
		@DeleteMapping(value="/delete/{id}")
		public String Del(@PathVariable("id") int num)
		{
			userSer.Del(num);
			return " deleted";
		}
		@PutMapping("/putProfile/{id}")
		public UserModel update(@RequestBody UserModel s,@PathVariable("id") int id)
		{
			return userSer.updateinfo(s,id);
		}
}
