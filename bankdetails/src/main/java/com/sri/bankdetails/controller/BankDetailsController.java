package com.sri.bankdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sri.bankdetails.model.BankDetailsModel;
import com.sri.bankdetails.service.BankDetailsService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController

public class BankDetailsController {

	@Autowired
	BankDetailsService hser;
	@Tag(name="Post All BankDetails",description="Post Details")
	@PostMapping("/postdetails")
	public BankDetailsModel addDetails(@RequestBody BankDetailsModel dd)
	{
		return hser.saveInfo(dd);
	}
	@Tag(name="Get All BankDetails",description="Get Details")
	@GetMapping("/getdetails")
	public List<BankDetailsModel> getDetails()
	{
		return hser.getInfo();
	}
	@Tag(name="Update All BankDetails",description="Update Details")
	@PutMapping("/updatedetails")
	public BankDetailsModel update(@RequestBody BankDetailsModel rs)
	{
		return hser.updateInfo(rs);
	}
	@Tag(name="Delete All BankDetails",description="Delete Details")
	@DeleteMapping("/deletedetails/{sno}")
	public String delete(@PathVariable("sno") int sh)
	{
		hser.deleteInfo(sh);
		return" deleted";
	}
//	@DeleteMapping("/deleteByReq")
//	public String deleteByRequestPara(@RequestParam ("sno") int m)
//	{
//		mser.deleteInfo(m);
//		return m+" is deleted";
//	}
	@Tag(name="Sort All BankDetails",description="Sort Details")
	@GetMapping ("/sortdetails/{field}")
	public List<BankDetailsModel> sortBankDetailsModel(@PathVariable String field)
	{
		return hser.sortAll(field);
	}
	@Tag(name="Page All BankDetails",description="Page Details")
	@GetMapping(value="/pagedetails/{field}/{size}")
	public List<BankDetailsModel> pagingBankDetailsModel(@PathVariable("field") int offset,@PathVariable("size") int  pageSize)
	
	{
	 return hser.pagingBankDetailsModel(offset, pageSize);	
	}
	@Tag(name="Pagination All BankDetails",description="Pagination Details")
	@GetMapping("pagination/{nm}/{sp}/{inr}")
	public List<BankDetailsModel> paginate(@PathVariable("nm") int num,@PathVariable("sp") int size,@PathVariable("inr") String name)
	{
		return hser.paginate(num,size,name);
	}//sp ---how many page split,inr - column name
	@Tag(name="Fetch Prefix BankDetails",description="Prefix Name")
	@GetMapping("/fetchPrefix")
	public List<BankDetailsModel> fetchBankDetailsByNamePrefix(@RequestParam String prefix)
	{
		return hser.fetchBankDetailsByNamePrefix(prefix);
	}
	@Tag(name="Fetch Suffix BankDetails",description="Suffix Name")
	@GetMapping("/fetchSuffix")
	public List<BankDetailsModel> fetchBankDetailsByNameSuffix(@RequestParam String suffix)
	{
		return hser.fetchBankDetailsByNameSuffix(suffix);
	}
	@Tag(name="Fetch By Branch BankDetails",description="Branch Details")
	@GetMapping("/fetchByBranch")
	public List<BankDetailsModel> fetchBankDetailsByBranch111(@RequestParam String branch)
	{
		return hser.getBankDetailsByBranch(branch);
	}
	@Tag(name="Dlete BankDetails",description="Delete Details")
	@DeleteMapping("/deleteBankDetailsByName/{name}")
    public String deleteBankDetailsByName(@PathVariable String name)
    {
 	   int result = hser.deleteBankDetailsByName(name);
 	   if(result>0)
 		     return "BankDetails record deleted";
 	   else
 		     return "Problem occured while deleting";
    }
	@Tag(name="Fetch branch Name BankDetails",description="Fetch BN Details")
	@GetMapping("/fetchBankDetailsBranch/{branch}/{name}")
	public List<BankDetailsModel>fetchBankByBranch(@PathVariable String branch,@PathVariable String name)
	{
		return hser.getBankByBranch(branch,name);
	}
	@Tag(name="Update branch Name BankDetails",description="Update Details")
	@PutMapping("/updateInstaByUsername/{branch}/{name}")
    public int updateInstaByUsername(@PathVariable String branch,@PathVariable String name)
    {
 	   return hser.updateBankDetailsByName(branch,name);
    }
	@Tag(name="Fetch branch BankDetails",description="Fetch B Details")
    @GetMapping("/fetchBankDetailsByBranch/{branch}")
    public List<BankDetailsModel>fetchByBranch(@PathVariable String branch)
    {
    	return hser.fetchBankDetailsByBranch(branch);
    }
}
