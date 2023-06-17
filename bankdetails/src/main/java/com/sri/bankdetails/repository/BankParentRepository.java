package com.sri.bankdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sri.bankdetails.model.BankParentModel;

@Repository
public interface BankParentRepository extends JpaRepository<BankParentModel,Integer> {

}
