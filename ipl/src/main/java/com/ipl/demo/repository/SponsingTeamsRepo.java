package com.ipl.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipl.demo.model.SponsingTeams;
@Repository
public interface SponsingTeamsRepo extends JpaRepository<SponsingTeams,Integer>{

}
