package com.sri.firstproject.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sri.firstproject.model.StudentModel;

@Repository

public interface StudentRep extends JpaRepository<StudentModel,Integer>{

	List<StudentModel> findByNameStartingWith(String prefix);
	List<StudentModel> findByNameEndingWith(String suffix);
	List<StudentModel> findByDept(String dept);
	StudentModel findByusername(String username);
}
