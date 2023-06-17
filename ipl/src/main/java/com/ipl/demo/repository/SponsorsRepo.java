package com.ipl.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipl.demo.model.Sponsors;
@Repository
public interface SponsorsRepo extends JpaRepository<Sponsors,Integer>{

}
