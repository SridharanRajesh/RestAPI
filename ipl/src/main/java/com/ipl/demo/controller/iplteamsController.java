package com.ipl.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.demo.model.teams;
import com.ipl.demo.service.iplteamsService;
@RestController
@CrossOrigin("http://localhost:3000")
public class iplteamsController {
	@Autowired
	iplteamsService iplser;
	
	@GetMapping(value="/fetchteams")
	public List<teams> getteams()
	{
		List<teams> teamsList=iplser.getteams();
		return teamsList;
		
	}
	@PostMapping(value="/postteams")
	public teams saveteam(@RequestBody teams t)
	{
		return iplser.saveteam(t);
	}
	
	@PutMapping(value="/updateteams")
	public teams putteam(@RequestBody teams t)
	{
		return iplser.updateteam(t);
	}
	
	@DeleteMapping(value="/deleteteams/{team}")
	public void deleteStudent(@PathVariable int team)
	{
		iplser.deleteteam(team);
		
	}
	@GetMapping(value="/get/{number}")
	public teams getteam(@PathVariable("number") int teamno)
	{
		return iplser.getteam(teamno);
	}
	
	@GetMapping("/sortascteams/{field}")
	public List<teams> sortascTeams(@PathVariable("field") String field)
	{
		return iplser.sortTeams(field);
	}
	
	@GetMapping("/sortdscteams/{field}")
	public List<teams> sortdscTeams(@PathVariable("field") String field)
	{
		return iplser.sortdesTeams(field);
	}
	@GetMapping("/pagingteams/{offset}/{pageSet}")
	public Page<teams> pagingteams(@PathVariable("offset") int offset,@PathVariable("pageSet") int pageSize)
	{
		return iplser.pagingteams(offset, pageSize);
	}
	@GetMapping("/pagingwithSortingteamss/{offset}/{pageSet}/{field}")
	public List<teams> pagingwithSortingteamss(@PathVariable("offset") int offset,@PathVariable("pageSet") int pageSize,@PathVariable("field") String field)
	{
		return iplser.pagingwithSortingteamss(offset, pageSize, field);
	}

	@GetMapping("/findByTeamnameStartingWith/{prefix}")
	public List<teams> findByTeamnameStartingWith(@PathVariable String prefix)
	{
		return iplser.findByTeamnameStartingWith(prefix);
	}
	
	@GetMapping("/findByTeamnameEndingWith/{suffix}")
	public List<teams> findByTeamnameEndingWith(@PathVariable String suffix)
	{
		return iplser.findByTeamnameEndingWith(suffix);
	}
	
	@GetMapping("/findByWins/{wins}")
	public List<teams> findByWins(@PathVariable String wins)
	{
		return iplser.findByWins(wins);
	}
	
	@GetMapping("/getTeamsByTeamname/{teamname}/{points}")
	public List<teams> getTeamsByTeamname(@PathVariable String teamname,@PathVariable String points)
	{
		return iplser.getTeamsByTeamname(teamname, points);
	}
	@GetMapping("/getTeamsByTeamname/{teamname}")
	public List<teams> getTeamByTeamname(String teamname)
	{
		return iplser.getTeamByTeamname(teamname);
	}
	@DeleteMapping("/deleteTeamByTeamname/{teamname}")
	public String deleteTeamByTeamname(@PathVariable String teamname)
	{
		int result=iplser.deleteTeamByTeamname(teamname);
		if(result>0)
			return "deleted";
		else
			return "error occured";
	}

	@PutMapping("updateTeamByTeamname/{captain}/{teamname}")
	public String updateTeamByTeamname(@PathVariable String captain,@PathVariable String teamname)
	{
		int res=iplser.updateTeamByTeamname(captain,teamname);
		if(res>0)
			return "updated!!";
		else
			return "error occured";
	}
	@GetMapping("/fetchTeamByLoses/{loses}")
	public List<teams> fetchTeamByLoses(@PathVariable String  loses)
	{
		return iplser.fetchTeamByLoses(loses);
	}
}
