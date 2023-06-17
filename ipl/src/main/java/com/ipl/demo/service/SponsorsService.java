package com.ipl.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.demo.model.Sponsors;
import com.ipl.demo.repository.SponsorsRepo;

@Service
public class SponsorsService {

	@Autowired
	SponsorsRepo srepo;
	public List<Sponsors> getSponsors() {
		
		return srepo.findAll();
	}
	public Sponsors putSponsors(Sponsors s) {
		
		return srepo.save(s);
	}
	
	public void del(int id)
	{
		srepo.deleteById(id);
	}

}
