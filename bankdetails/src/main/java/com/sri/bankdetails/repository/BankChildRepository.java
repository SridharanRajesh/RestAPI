package com.sri.bankdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sri.bankdetails.model.BankChildModel;


@Repository
public interface BankChildRepository extends JpaRepository<BankChildModel,Integer>{
 
}
