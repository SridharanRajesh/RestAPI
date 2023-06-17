package com.sri.bankdetails.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class BankParentModel {

	@Id
	private int id;
	private String name;
	private String address;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="address_id")
	private BankChildModel details;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BankChildModel getDetails() {
		return details;
	}
	public void setDetails(BankChildModel details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "BankParentModel [id=" + id + ", name=" + name + ", address=" + address + ", details=" + details + "]";
	}
}
