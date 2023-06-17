package com.projectreview.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectreview.demo.model.loginPage;

@Repository
public interface loginRepo extends JpaRepository<loginPage, Integer> {

	loginPage findByUsername(String username);
}
