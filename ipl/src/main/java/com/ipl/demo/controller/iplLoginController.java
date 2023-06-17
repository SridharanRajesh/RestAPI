package com.ipl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipl.demo.model.iplLoginDemo;
import com.ipl.demo.service.iplLoginSer;

@CrossOrigin("http://localhost:3000")
@RestController

@RequestMapping("/user")
public class iplLoginController {
	
	@Autowired
	private iplLoginSer lser;
	
	@GetMapping("/log/{username}/{password}")
	public boolean login(@PathVariable String username,@PathVariable String password)
	{
		
		boolean result=lser.checkLogin(username,password);
		return result;
		
	}
	@PutMapping("/put")
	public iplLoginDemo putUser(@RequestBody iplLoginDemo cl)
	{
		return lser.putUser(cl);
	}
	@PostMapping("/adduser")
	public boolean AddUser(@RequestBody iplLoginDemo cl)
	{
		return lser.addUser(cl);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id )
	{
		lser.delete(id);
	}
	
	@GetMapping("/showall")
	public List<iplLoginDemo> listAll()
	{
		return lser.getUser();
	}
	
}
