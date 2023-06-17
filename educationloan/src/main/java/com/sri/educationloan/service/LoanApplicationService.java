package com.sri.educationloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.educationloan.model.LoanApplicationModel;
import com.sri.educationloan.repository.LoanApplicationRepo;

@Service
public class LoanApplicationService {
		@Autowired
		LoanApplicationRepo laRep;
		public List<LoanApplicationModel> get()
		{
			List<LoanApplicationModel> l=laRep.findAll();
			return l;
		}
		public LoanApplicationModel saveUser( LoanApplicationModel l)
		{
			return laRep.save(l);
		}
		public void Del(int id)
		{
			laRep.deleteById(id);
		}
		public void deleteDetails(int id)
		{
			laRep.deleteById(id);
		}
		public LoanApplicationModel updateDetailsS(LoanApplicationModel s)
		{
			LoanApplicationModel obj = laRep.save(s);
			return obj;
		}
}