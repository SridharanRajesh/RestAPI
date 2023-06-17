package com.projectreview.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectreview.demo.model.loginPage;
import com.projectreview.demo.repository.loginRepo;

@Service
public class loginService {

	@Autowired
	loginRepo lrep;
	
	public loginPage saveUser(loginPage l)
	{
		return lrep.save(l);
	}
	
	public String validateUser(String username,String password)
	{
		String result="";
		loginPage l=lrep.findByUsername(username);
		if(l==null)
		{
			result="Invalid user";
		}
			else
			{
				if(l.getPassword().equals(password))
				{
					result="Login success";
				}
				else
				{
					result="Login failed";
				}
			}
		

		return result;
		}
}
