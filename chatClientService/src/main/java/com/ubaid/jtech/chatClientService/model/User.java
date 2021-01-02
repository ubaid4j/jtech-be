package com.ubaid.jtech.chatClientService.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	private Long id;

	private String firstName;

	private String midName;

	private String lastName;

	private String imageURL;

	private Integer port;
	
	private Boolean isActive;

	private Timestamp lastSeen;

	@JsonIgnore
	private String email;
	
	@JsonIgnore
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(Timestamp lastSeen) {
		this.lastSeen = lastSeen;
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

	public User(String firstName, String midName, String lastName, String imageURL, Integer port, Boolean isActive,
			Timestamp lastSeen, String email, String password) {
		super();
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.imageURL = imageURL;
		this.port = port;
		this.isActive = isActive;
		this.lastSeen = lastSeen;
		this.email = email;
		this.password = password;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", midName=" + midName + ", lastName=" + lastName
				+ ", imageURL=" + imageURL + ", port=" + port + ", isActive=" + isActive + ", lastSeen=" + lastSeen
				+ ", email=" + email + ", password=" + password + "]";
	}
}
