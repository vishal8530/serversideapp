package com.applicationform.Applicationdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  private String firstname;
	  private String lastname;
	  private String state;
	  private String district;
	  private String about;
	  
	  
		public User() {
			super();
		}
	  
	  public User(Long id, String firstname, String lastname, String state, String district, String about) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.state = state;
			this.district = district;
			this.about = about;
		}
	  
	  
	  
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}



	
	
	
	  
	  

}
