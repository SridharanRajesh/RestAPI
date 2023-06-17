package com.projectreview.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectreview.demo.model.Artist;
import com.projectreview.demo.repository.Artistrepo;

@Service
public class ArtistAddressService {

	@Autowired
	Artistrepo arep;
	
	public List<Artist> fetchAllArtists(){
		List<Artist> c=arep.findAll();
		return c;
	}
	
	public Artist saveArtists(Artist p) {
		Artist s=arep.save(p);
		return s;
	}
	
}
