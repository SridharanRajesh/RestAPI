package com.sri.bankdetails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class BankChildModel {

	@Id
	   private Long id;
	   private String street;
	   private String city;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "BankChildModel [id=" + id + ", street=" + street + ", city=" + city + "]";
	}
	
}
