package com.projectreview.demo.model;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Top10songs")
public class Billboard {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // automatically generated primary key.
	@Column(name="SId")
	private int sno;
	private String songname;
	private String artistname;
	private String dateofrelease;
	private String genre;
	private String duration;
	private int rating;
	private int position;
	private int avglisteners;
	private String officialemail;
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSongname() {
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	public String getArtistname() {
		return artistname;
	}
	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}
	public String getDateofrelease() {
		return dateofrelease;
	}
	public void setDateofrelease(String dateofrelease) {
		this.dateofrelease = dateofrelease;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getAvglisteners() {
		return avglisteners;
	}
	public void setAvglisteners(int avglisteners) {
		this.avglisteners = avglisteners;
	}
	public String getOfficialemail() {
		return officialemail;
	}
	public void setOfficialemail(String officialemail) {
		this.officialemail = officialemail;
	}
}
