package com.sri.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sri.firstproject.model.loginpage;

@Repository
public interface loginRepo extends JpaRepository<loginpage, Integer> {

	loginpage findByUsername(String username);
}
