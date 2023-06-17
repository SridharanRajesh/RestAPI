package com.ipl.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Sponsors {
	@Id
	@GeneratedValue
	private int sponsId;
	@Override
	public String toString() {
		return "Sponsors [sponsId=" + sponsId + ", sponsName=" + sponsName + ", team=" + team + "]";
	}
	public Sponsors() {
		super();
	}
	public int getSponsId() {
		return sponsId;
	}
	public void setSponsId(int sponsId) {
		this.sponsId = sponsId;
	}
	public String getSponsName() {
		return sponsName;
	}
	public void setSponsName(String sponsName) {
		this.sponsName = sponsName;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	private String sponsName;
	private String team;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="teamId")
	private SponsingTeams spteams;
	public SponsingTeams getSpteams() {
		return spteams;
	}
	public void setSpteams(SponsingTeams spteams) {
		this.spteams = spteams;
	}
}
