package com.microservice.user.service.UserService.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;

@Entity
@Builder

public class User {
	
	@Id
	@Column(name="ID")
	private Integer userId;
	
	@Column(name="NAME")
	private String userName;
	
	@Column(name="EMAIl")
	private String userEmail;
	
	@Column(name="ABOUT")
	private String userAbout;
	
	@Transient
	private List<Rating> ratings; 
	
	

	public User() {
		super();
	}

	

	public User(Integer userId, String userName, String userEmail, String userAbout, List<Rating> ratings) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAbout = userAbout;
		this.ratings = ratings;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAbout() {
		return userAbout;
	}

	public void setUserAbout(String userAbout) {
		this.userAbout = userAbout;
	}



	public List<Rating> getRatings() {
		return ratings;
	}



	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	

}
