package com.sri.bankdetails.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.sri.bankdetails.model.BankDetailsModel;
import com.sri.bankdetails.repository.BankDetailsRepository;

import jakarta.transaction.Transactional;

@Service

public class BankDetailsService {

	@Autowired  
	BankDetailsRepository irep;
	
	//Posting The Information
	public BankDetailsModel saveInfo(BankDetailsModel dd)
	{
		return irep.save(dd);
	}
	
	//Getting The Information
	public List <BankDetailsModel> getInfo()
	{
		return irep.findAll();
	}
	
	//Update The Information
	public BankDetailsModel updateInfo(BankDetailsModel xx)
	{
		return irep.saveAndFlush(xx);
	}
	
	//Delete The Information
	public void deleteInfo(int no)
	{
		irep.deleteById(no);
	}
	//sorting Ascending Order
//	public List<BankDetailsModel> sortAll(String field)
//	{
//		return irep.findAll(Sort.by(field));
//	}
	
	//sorting Descending Order
	public List<BankDetailsModel> sortAll(String f)
	{
		return irep.findAll(Sort.by(Direction.DESC, f)) ;
	}
		
	//pagination
	public List<BankDetailsModel>pagingBankDetailsModel(int offset,int  pageSize)
	{
		Page<BankDetailsModel>obj= irep.findAll(PageRequest.of(offset, pageSize));
		return obj.getContent();
	}
	
	public List<BankDetailsModel> paginate(int offset, int pageSize, String username) 
	{
		Page<BankDetailsModel> obj=irep.findAll(PageRequest.of(offset, pageSize,Sort.by(username).descending()));
		return obj.getContent();
	}
	
	// Prefix
	public List<BankDetailsModel> fetchBankDetailsByNamePrefix(String prefix)
	{
		return irep.findByNameStartingWith(prefix);
	}
	
	//Suffix
	public List<BankDetailsModel> fetchBankDetailsByNameSuffix(String suffix)
	{
		return irep.findByNameEndingWith(suffix);
	}
	
	public List<BankDetailsModel> getBankDetailsByBranch(String branch)
	  {
		  return irep.getBankDetailsByBranch(branch);
	  }
	public List<BankDetailsModel>getBankByBranch(String branch,String name)
	{
		return irep.getBankDetailsByBranch(branch,name);
	}
	@Transactional 
	public int deleteBankDetailsByName(String name)
	{
		return irep.deleteBankDetailsByName(name);
	}
	@Transactional
	public int updateBankDetailsByName(String branch,String name)
	{
		return irep.updateBankDetailsByName(branch, name);
	}
	public List<BankDetailsModel> fetchBankDetailsByBranch(String branch)
	{
		return irep.fetchBankDetailsbranch(branch);
	}
}
