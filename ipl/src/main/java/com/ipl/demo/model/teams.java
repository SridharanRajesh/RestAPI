package com.ipl.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class teams {

	@Id
	private int teamno;
	private String teamname;
	private String captain;
	public teams() {
		super();
	}
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	@Override
	public String toString() {
		return "teams [teamno=" + teamno + ", teamname=" + teamname + ", captain=" + captain + ", wins=" + wins
				+ ", loses=" + loses + ", points=" + points + "]";
	}
	
	private int wins;
	private int loses;
	private int points;
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLoses() {
		return loses;
	}
	public void setLoses(int loses) {
		this.loses = loses;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getTeamno() {
		return teamno;
	}
	public void setTeamno(int teamno) {
		this.teamno = teamno;
	}
}
