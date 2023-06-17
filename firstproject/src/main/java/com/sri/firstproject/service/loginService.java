package com.sri.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.firstproject.model.loginpage;
import com.sri.firstproject.repository.loginRepo;

@Service
public class loginService {
	
	@Autowired
	loginRepo lrep;
		
		public loginpage saveUser(loginpage l)
		{
			return lrep.save(l);
		}
		
		public String validateUser(String username,String password)
		{
			String result="";
			loginpage l=lrep.findByUsername(username);
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
