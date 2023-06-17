package com.ipl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.demo.model.Sponsors;
import com.ipl.demo.service.SponsorsService;

@RestController
public class SponsorsController {

	@Autowired
	public SponsorsService sSer;
	@GetMapping("/getSponsors")
	public List<Sponsors> getSponsors()
	{
		return sSer.getSponsors();
	}
	@DeleteMapping("/deleteSponsors/{id}")
	public void deleteem(int id)
	{
		sSer.del(id);
		
	}
	@PostMapping("/postSponsors")
	public Sponsors postSponsors(@RequestBody Sponsors s)
	{
		return sSer.putSponsors(s);
	}
}
