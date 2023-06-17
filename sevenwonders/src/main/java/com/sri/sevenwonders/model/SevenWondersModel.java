package com.sri.sevenwonders.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SevenWondersModel {

    @Id
	private int sno;
	private String name;
	private String country;
	private int avg_visit;
	private int entry_fees;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAvg_visit() {
		return avg_visit;
	}
	public void setAvg_visit(int avg_visit) {
		this.avg_visit = avg_visit;
	}
	public int getEntry_fees() {
		return entry_fees;
	}
	public void setEntry_fees(int entry_fees) {
		this.entry_fees = entry_fees;
	}
	
	
	
}
