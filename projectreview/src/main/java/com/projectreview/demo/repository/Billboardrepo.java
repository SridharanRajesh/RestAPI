package com.projectreview.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectreview.demo.model.Billboard;

@Repository

public interface Billboardrepo extends JpaRepository<Billboard, Integer>{

	
	 //	positional parameter
	@Query("select s from Billboard s where s.artistname=?1 and s.rating=?2" )
	public List<Billboard> getCustomersByArtistname(String name,String rating);
	
	//named parameter
	@Query("select s from Billboard s where s.artistname=:name")
	public List<Billboard> getCustomersByArtistname(String name);
	
	//DML
	@Modifying
	@Query("delete from Billboard s where s.artistname=?1")
	public int deleteCustomersByArtistname(String name);
	
	@Modifying
	@Query("update Billboard s set s.rating=?1 where s.artistname=?2")
	public int updateCustomersByArtistname(String rating,String name);
	
	//MySql Query
	@Query(value="select * from Billboard s where s.officialemail=?1",nativeQuery=true)
	public List<Billboard> fetchStudentsByEmail(String gen);
	
	
	List<Billboard>findBySongnameStartingWith(String prefix);
	List<Billboard>findBySongnameEndingWith(String suffix);
}
