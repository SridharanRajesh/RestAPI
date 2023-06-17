package com.ipl.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ipl.demo.model.teams;
@Repository
public interface iplteamsRepo extends JpaRepository<teams,Integer> {

	List<teams> findByTeamnameStartingWith(String prefix);
	List<teams> findByTeamnameEndingWith(String suffix);
	List<teams> findByWins(String wins);
	
	@Query("select s from teams s where s.teamname=?1 and s.points=?2" )
	public List<teams> getTeamsByTeamname(String teamname,String points);
	
	//named parameter
	@Query("select s from teams s where s.teamname=:teamname")
	public List<teams> getTeamByTeamname(String teamname);
	
	//DML
	@Modifying
	@Query("delete  from teams s where s.teamname=?1")
	public int deleteTeamByTeamname(String teamname);
	
	
	@Modifying
	@Query("update   teams s set s.captain=?1 where s.teamname=?2")
	public int updateTeamByTeamname(String captain,String teamname);

	@Query(value="select * from teams  s where  s.loses= ?1", nativeQuery=true)
	public List<teams> fetchTeamByLoses(String  email);
}
