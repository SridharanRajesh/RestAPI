package com.sri.bankdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sri.bankdetails.model.BankParentModel;
import com.sri.bankdetails.service.ParentChildService;

@RestController
public class ParentChildController {

	@Autowired
	ParentChildService apService;
	@GetMapping("/getAllPersons")
     public List<BankParentModel> fetchAllPersons()
	   {
		  return apService.fetchAllPersons();
	   }
	   @PostMapping("/saveAlldata")
	   public BankParentModel savePersons(@RequestBody BankParentModel p)
	   {
		   return apService.saveBankParentModel(p);
	   }
}
