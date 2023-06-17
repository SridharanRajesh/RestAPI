package com.ipl.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SponsingTeams {

	@Id
	private int teamId;
	@Override
	public String toString() {
		return "SponsingTeams [teamId=" + teamId + ", tname=" + tname + ", cups=" + cups + "]";
	}
	public SponsingTeams() {
		super();
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getCups() {
		return cups;
	}
	public void setCups(String cups) {
		this.cups = cups;
	}
	private String tname;
	private String cups;
}
