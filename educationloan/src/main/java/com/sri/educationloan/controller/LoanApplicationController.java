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
import com.sri.educationloan.service.LoanApplicationService;

@RestController
@RequestMapping("/admin")

public class LoanApplicationController {

		@Autowired
		LoanApplicationService laSer;
		@GetMapping(value="/getAllLoans")
		public List<LoanApplicationModel> get()
		{
			List<LoanApplicationModel> l=laSer.get();
			return l;
		}
		@PostMapping(value="/postadmin")
		public LoanApplicationModel saveUser(@RequestBody LoanApplicationModel l)
		{
			return laSer.saveUser(l);
		}
		@DeleteMapping("/deleteuser/{id}")
		  public String deleteDetails(@PathVariable("id") int hid)
		  {
			  laSer.deleteDetails(hid);
			  return " deleted";
		}
		@PutMapping("/update")
		public LoanApplicationModel updateDetails(@RequestBody LoanApplicationModel s)
		{
			return laSer.updateDetailsS(s);
		}
}
