 package com.sri.bankdetails.repository;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.sri.bankdetails.model.BankDetailsModel;

public interface BankDetailsRepository extends JpaRepository<BankDetailsModel,Integer>{

	List<BankDetailsModel> findByNameStartingWith(String prefix);
	List<BankDetailsModel> findByNameEndingWith(String suffix);
	List<BankDetailsModel> findByBranch(String branch);
	
	//positional parameter,order should match
	@Query("select s from BankDetailsModel s where s.branch=?1 and s.name=?2")
	public List<BankDetailsModel> getBankDetailsByBranch(String branch,String name);
			
    //named parameter
	@Query("select s from BankDetailsModel s where s.branch=:branch")
	public List<BankDetailsModel> getBankDetailsByBranch(String branch);
	
	//DML
	@Modifying
	@Query("delete from BankDetailsModel s where s.name=?1")
	public int deleteBankDetailsByName(String name);
	
	@Modifying
	@Query("update BankDetailsModel s set s.branch=?1 where s.name=?2")
	public int updateBankDetailsByName(String branch,String name);
	
	@Query(value="select * from BankDetailsModel s where s.branch=?",nativeQuery=true)
	public List<BankDetailsModel> fetchBankDetailsbranch(String branch);
}
