package com.projectreview.demo.service;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projectreview.demo.model.Billboard;
import com.projectreview.demo.repository.Billboardrepo;

import jakarta.transaction.Transactional;

@Service
public class BillboardService {

	@Autowired
	public Billboardrepo brep;
	
	//posting the info
	public Billboard saveInfo(Billboard r)
	{
		return brep.save(r);
	}
	
	//displaying the info
	public List<Billboard> getInfo()
	{
		return brep.findAll();
	}
	
	//updating the info
	public void updateInfo(Billboard u,int position)
	{
		brep.save(u);
	}
	
	//deleting the info
	public void deleteInfo(int sno)
	{
		brep.deleteById(sno);
	}
	
	//sorting
	public List<Billboard> sortAll(String field)
	{
		return brep.findAll(Sort.by(Direction.DESC, field)) ;
	}
	
	//pagination
	public List<Billboard>pagingBillboard(int offset,int  pageSize)
	{
		Page<Billboard>   obj= brep.findAll(PageRequest.of(offset, pageSize));
		return obj.getContent();
	}
	
	//pagination and sorting
	public List<Billboard> paginate(int offset, int pageSize, String username) 
	{
		Page<Billboard> obj=brep.findAll(PageRequest.of(offset, pageSize,Sort.by(username).ascending()));
		return obj.getContent();
	}
	
	//prefix and suffix
	public List<Billboard> fetchCustomersByNamePrefix(String prefix)
	{
		return brep.findBySongnameStartingWith(prefix);
	}
	public List<Billboard> fetchCustomersByNameSuffix(String suffix)
	{
		return brep.findBySongnameEndingWith(suffix);
	}
	
	public List<Billboard> getCustomersByArea(String artistname,String rating)
	  {
		  return brep.getCustomersByArtistname(artistname, rating);
	  }
	
	//DML
		@Transactional
		public int deleteCustomerByname(String name) {
			return brep.deleteCustomersByArtistname(name);
		}
		
		@Transactional
		public int updateCustomerByname(String rating,String name) {
			return brep.updateCustomersByArtistname(rating, name);
		}
}