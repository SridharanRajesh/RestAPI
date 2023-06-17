package com.sri.sevenwonders.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.sri.sevenwonders.model.SevenWondersModel;
import com.sri.sevenwonders.repository.SevenWondersRepository;

@Service
public class SevenWondersService {

	@Autowired  
	SevenWondersRepository srep;
	
	//Posting The Information
	public SevenWondersModel saveInfo(SevenWondersModel dd)
	{
		return srep.save(dd);
	}
	
	//Getting The Information
	public List <SevenWondersModel> getInfo()
	{
		return srep.findAll();
	}
	
	//Update The Information
	public SevenWondersModel updateInfo(SevenWondersModel xx)
	{
		return srep.saveAndFlush(xx);
	}
	
	//Delete The Information
	public void deleteInfo(int no)
	{
		srep.deleteById(no);
	}
	//sorting Ascending Order
	public List<SevenWondersModel> sortAll(String field)
	{
		return srep.findAll(Sort.by(field));
	}
	
	//sorting Descending Order
//	public List<SevenWondersModel> sortAll(String f)
//	{
//		return srep.findAll(Sort.by(Direction.DESC, f)) ;
//	}
		
	//pagination
	public List<SevenWondersModel>pagingSevenWondersModel(int offset,int  pageSize)
	{
		Page<SevenWondersModel>obj= srep.findAll(PageRequest.of(offset, pageSize));
		return obj.getContent();
	}
	
	public List<SevenWondersModel> paginate(int offset, int pageSize, String username) 
	{
		Page<SevenWondersModel> obj=srep.findAll(PageRequest.of(offset, pageSize,Sort.by(username).descending()));
		return obj.getContent();
	}
	
	// Prefix
	public List<SevenWondersModel> fetchStudentByNamePrefix(String prefix)
	{
		return srep.findByNameStartingWith(prefix);
	}
	
	//Suffix
	public List<SevenWondersModel> fetchStudentByNameSuffix(String suffix)
	{
		return srep.findByNameEndingWith(suffix);
	}
}
