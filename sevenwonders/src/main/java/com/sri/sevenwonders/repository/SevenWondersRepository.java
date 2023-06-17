package com.sri.sevenwonders.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sri.sevenwonders.model.SevenWondersModel;

@Repository

public interface SevenWondersRepository extends JpaRepository<SevenWondersModel,Integer>{

	List<SevenWondersModel> findByNameStartingWith(String prefix);
	List<SevenWondersModel> findByNameEndingWith(String suffix);
}