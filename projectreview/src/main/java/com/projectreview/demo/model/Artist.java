package com.projectreview.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Artist")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String password;
	private int totalSongs;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Artist address;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTotalSongs() {
		return totalSongs;
	}
	public void setTotalSongs(int totalSongs) {
		this.totalSongs = totalSongs;
	}
	public Artist getAddress() {
		return address;
	}
	public void setAddress(Artist address) {
		this.address = address;
	}
	
}
