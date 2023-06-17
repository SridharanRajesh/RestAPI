package com.ipl.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ipl.demo.model.teams;
import com.ipl.demo.repository.iplteamsRepo;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class iplteamsService {

	@Autowired
	iplteamsRepo repo;

	
	public List<teams> getteams()
	{
		List<teams> teamsList=repo.findAll();
		return teamsList;
	}
	
	public teams saveteam(teams t) {
		
		teams obj=repo.save(t);
		return obj;
	}
	
	public teams updateteam(teams t) {
		
		teams obj=repo.save(t);
		return obj;
	}

	public void deleteteam(int teamno) {
		repo.deleteById(teamno);;
		
	}

	public teams getteam(int teamno) {
		teams obj=repo.findById(teamno).get();
		return obj;
	}
	
	public List<teams> sortdesTeams(String field) {
		return repo.findAll(Sort.by(Direction.DESC, field));
	}
	
	public List<teams> sortTeams(String field) {
		return repo.findAll(Sort.by(Direction.ASC, field));
	}
	
	public Page<teams> pagingteams(int offset,int pageSize)
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<teams> studData=repo.findAll(paging);
		//List<Student> studList=studData.getContent();
		return studData;
	}
	public List<teams> pagingwithSortingteamss(int offset,int pageSize,String field)
	{
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
		Page<teams> stud=repo.findAll(paging);
		return stud.getContent();
	}
	
		public List<teams> findByTeamnameStartingWith(String prefix)
		{
			return repo.findByTeamnameStartingWith(prefix);
		}
		public List<teams> findByTeamnameEndingWith(String suffix)
		{
			return repo.findByTeamnameEndingWith(suffix);
		}
		public List<teams> findByWins(String wins)
		{
			return repo.findByWins(wins);
		}
		public List<teams> getTeamsByTeamname(String teamname,String points)
		{
			return repo.getTeamsByTeamname(teamname, points);
		}
		
		public List<teams> getTeamByTeamname(String teamname)
		{
			return repo.getTeamByTeamname(teamname);
		}
		@Transactional
		public int deleteTeamByTeamname(String teamname)
		{
			return repo.deleteTeamByTeamname(teamname);
		}
		@Transactional
		public int updateTeamByTeamname(String captain,String teamname)
		{
			return repo.updateTeamByTeamname(captain,teamname);
		}
		public List<teams> fetchTeamByLoses(String  loses)
		{
			return repo.fetchTeamByLoses(loses);
		}
}
