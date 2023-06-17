package com.ipl.demo.model;
	import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name="iplLoginDemo")
	public class iplLoginDemo 
	{
		@Id
		@GeneratedValue
		private int id;
		private String username;
		private String password;
		private int age;
		private String gender;
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		private String email;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public String toString() {
			return "iplLoginDemo [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age
					+ ", gender=" + gender + ", email=" + email + "]";
		}
		}
	
	

