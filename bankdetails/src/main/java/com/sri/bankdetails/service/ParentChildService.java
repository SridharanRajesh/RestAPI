package com.sri.bankdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.bankdetails.model.BankParentModel;
import com.sri.bankdetails.repository.BankParentRepository;

@Service
public class ParentChildService {

	@Autowired
	BankParentRepository perRepository;
	public List<BankParentModel>fetchAllPersons()
	   {
		   return perRepository.findAll();
	   }
    public BankParentModel saveBankParentModel(BankParentModel p)
	   {
		   return perRepository.save(p);
	   }
}
