package com.projectreview.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectreview.demo.model.Address;

@Repository
public interface Addressrepo extends JpaRepository<Address, Integer> {

}
