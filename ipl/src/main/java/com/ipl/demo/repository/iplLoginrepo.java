package com.ipl.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipl.demo.model.iplLoginDemo;
@Repository
public interface iplLoginrepo extends JpaRepository<iplLoginDemo, Integer>  {

	
	public iplLoginDemo findByUsername(String username);
}
