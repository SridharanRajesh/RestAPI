package com.projectreview.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectreview.demo.model.Artist;
import com.projectreview.demo.service.ArtistAddressService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class ArtistController {

	@Autowired
	ArtistAddressService aser;
	
	@Tag(name="getAllOrderDetails",description="getAll")
	@GetMapping("/getAllCustomers")
	public List<Artist> fetchAllCustomers() {
		List<Artist> pList=aser.fetchAllArtists();
		return pList;
	}
	
	@PostMapping("/saveCustomers") 
	public Artist saveCustomers(@RequestBody Artist p) {
		return aser.saveArtists(p);
	}
}
