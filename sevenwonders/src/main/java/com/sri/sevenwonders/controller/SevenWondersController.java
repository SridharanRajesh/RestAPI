package com.sri.sevenwonders.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sri.sevenwonders.model.SevenWondersModel;
import com.sri.sevenwonders.service.SevenWondersService;

@RestController

public class SevenWondersController {
	
	@Autowired 
	SevenWondersService mser;
	@PostMapping("/postwonder")
	public SevenWondersModel addDetails(@RequestBody SevenWondersModel dd)
	{
		return mser.saveInfo(dd);
	}
	@GetMapping("/getwonder")
	public List<SevenWondersModel> getDetails()
	{
		return mser.getInfo();
	}
	@PutMapping("/updatewonder")
	public SevenWondersModel update(@RequestBody SevenWondersModel rs)
	{
		return mser.updateInfo(rs);
	}
	@DeleteMapping("/deletewonder/{sno}")
	public String delete(@PathVariable("sno") int sh)
	{
		mser.deleteInfo(sh);
		return" deleted";
	}
//	@DeleteMapping("/deleteByReq")
//	public String deleteByRequestPara(@RequestParam ("sno") int m)
//	{
//		mser.deleteInfo(m);
//		return m+" is deleted";
//	}
	@GetMapping ("/sortwonders/{field}")
	public List<SevenWondersModel> sortStudentModel(@PathVariable String field)
	{
		return mser.sortAll(field);
	}
	@GetMapping(value="/pagewonders/{field}/{size}")
	public List<SevenWondersModel> pagingSevenWondersModel(@PathVariable("field") int offset,@PathVariable("size") int  pageSize)
	
	{
	 return mser.pagingSevenWondersModel(offset, pageSize);	
	}
	@GetMapping("pagination/{nm}/{sp}/{inr}")
	public List<SevenWondersModel> paginate(@PathVariable("nm") int num,@PathVariable("sp") int size,@PathVariable("inr") String name)
	{
		return mser.paginate(num,size,name);
	}//sp ---how many page split,inr - column name
	@GetMapping("/fetchPrefix")
	public List<SevenWondersModel> fetchStudentByNamePrefix(@RequestParam String prefix)
	{
		return mser.fetchStudentByNamePrefix(prefix);
	}
	@GetMapping("/fetchSuffix")
	public List<SevenWondersModel> fetchStudentByNameSuffix(@RequestParam String suffix)
	{
		return mser.fetchStudentByNameSuffix(suffix);
	}
}


