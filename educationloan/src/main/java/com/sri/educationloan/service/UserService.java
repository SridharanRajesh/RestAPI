package com.sri.educationloan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.educationloan.model.LoanApplicationModel;
import com.sri.educationloan.model.UserModel;
import com.sri.educationloan.repository.LoanApplicationRepo;
import com.sri.educationloan.repository.UserRepo;

@Service
public class UserService {

		@Autowired
		UserRepo userRep;
		@Autowired
		LoanApplicationRepo laRep;
		public UserModel saveUser(UserModel l)
		{
			return userRep.save(l);
		}
		public String valideteUser(String email,String password)
		{
			String result=" ";
			UserModel l=userRep.findByEmail(email);
			if(l==null)
			{
				result="User not found";
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
		public List<UserModel> get()
		{
			List<UserModel> um=userRep.findAll();
			return um;
		}
		public LoanApplicationModel getById(int id)
		{
			LoanApplicationModel gbi=laRep.findById(id).get();
			return gbi;
		}
		public void Del(int id)
		{
			userRep.deleteById(id);
		}
		public  UserModel updateinfo(UserModel s,int id) {
			Optional<UserModel> optional=userRep.findById(id);
			UserModel obj=null;
			if(optional.isPresent())
			{
			obj=optional.get();

			userRep.save(s);
			}
			return obj;


			}
}
