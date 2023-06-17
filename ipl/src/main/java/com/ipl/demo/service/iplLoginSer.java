package com.ipl.demo.service;
import com.ipl.demo.model.*;
import com.ipl.demo.repository.iplLoginrepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class iplLoginSer {

@Autowired
private iplLoginrepo lrepo;


public boolean checkLogin(String username,String password)
{
	iplLoginDemo user= lrepo.findByUsername(username);
	System.out.print(user);
	if(user==null)
	{
		return false;
	}
	else
	{
		if(user.getPassword().equals(password))
		{
			System.out.print(user.getPassword());
			return true;
		}
		else
		{
			return false;
		}
	}
	
} 
public boolean addUser(iplLoginDemo cl)
{
	iplLoginDemo res= lrepo.save(cl);
	if(res!=null)
		return true;
	else
		return false;
}
public List<iplLoginDemo> getUser()
{
	return lrepo.findAll();
}
public iplLoginDemo putUser(iplLoginDemo cl)
{
	return lrepo.save(cl);
}
public void delete(int id) {
	lrepo.deleteById(id);
	
}
}
