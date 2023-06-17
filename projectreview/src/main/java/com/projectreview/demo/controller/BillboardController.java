package com.projectreview.demo.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectreview.demo.model.Billboard;
import com.projectreview.demo.service.BillboardService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class BillboardController {

	@Autowired
	public BillboardService bser;
	
	@PostMapping("/insert")
	public Billboard addDetails(@RequestBody Billboard ad)
	{
		return bser.saveInfo(ad);
	}
	
	@GetMapping("/display")
	public List<Billboard> getDetails()
	{
		return bser.getInfo();
	}
	
	@PutMapping("/update/{position}")
	 public ResponseEntity<String> update(@PathVariable("position") int position, @RequestBody Billboard b) {
        bser.updateInfo(b,position);
        return ResponseEntity.ok("User updated successfully");
	}
    
	
	@DeleteMapping("/deleteByPV/{sno}")
	public String deleteDetails(@PathVariable("sno") int position)
	{
		bser.deleteInfo(position);
		return " deleted";
	}
	
	@DeleteMapping("/deleteByReq")
	public String deleteByReq(@RequestParam ("position") int sno)
	{
		bser.deleteInfo(sno);
		return sno + " is deleted";
	}
	
	@GetMapping("/sortBillboard/{field}")
	public List<Billboard> sortBillboard(@PathVariable String field)
	{
		return bser.sortAll(field);
	}
	
	//pagination
	@GetMapping(value="/pageStudents/{field}/{size}")
	public List<Billboard> pagingBillboard(@PathVariable("field") int offset,@PathVariable("size") int  pageSize)
	
	{
	 return bser.pagingBillboard(offset, pageSize);	
	}
	
	//pagination and sorting
	@GetMapping("pagination/{nm}/{sp}/{inr}")
	public List<Billboard> paginate(@PathVariable("nm") int num,@PathVariable("sp") int size,@PathVariable("inr") String name)
	{
		return bser.paginate(num,size,name);
	}
	
	//http://localhost:8080/fetchCustomersByNamePrefix?prefix=a
		@GetMapping("/fetchCustomersByNamePrefix")
		public List<Billboard>fetchCustomersBySongnamePrefix(@RequestParam String prefix)
		{
			return bser.fetchCustomersByNamePrefix(prefix);
		}
		//http://localhost:8080/fetchCustomersByNameSuffix?suffix=b
		@GetMapping("/fetchCustomersByNameSuffix")
		public List<Billboard>fetchCustomersBySongnameSuffix(@RequestParam String suffix)
		{
			return bser.fetchCustomersByNameSuffix(suffix);
		}
		
		@GetMapping("/fetchCustomersByArtistname/{area}/{type}")
		 public List<Billboard> fetchCustomersByArea(@PathVariable String area,@PathVariable String type)
		 {
		 	return bser.getCustomersByArea(area, type);
		 }
		 @DeleteMapping("/deleteCustomerByName/{name}")
		 public String deleteCustomerByName(@PathVariable String name) {
			 int result=bser.deleteCustomerByname(name);
			 if(result>0)
				 return "Customer record deleted";
			 else
				 return "Problem occured while deleting";
		 }
		 
		 @PutMapping("/updateCustomerByName/{rating}/{name}")
		 public String updateCustomerByName(@PathVariable String rating,@PathVariable String name) {
			 int result=bser.updateCustomerByname(rating,name);
			 if(result>0)
				 return "Customer record updated";
			 else
				 return "Problem occured while updating";
		 }

}
