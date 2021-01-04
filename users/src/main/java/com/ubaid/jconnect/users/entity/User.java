package com.ubaid.jconnect.users.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String firstName;

	@Column
	private String midName;

	@Column
	private String lastName;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	private String imageURL;

	@Column
	private Boolean isActive;

	@Column
	private Boolean isLoggedIn;

	@Column
	private Timestamp lastSeen;

	@Column
	private Timestamp dateCreated;

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

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public Timestamp getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(Timestamp lastSeen) {
		this.lastSeen = lastSeen;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public User(String firstName, String midName, String lastName, String email, String password, String imageURL,
			Boolean isActive, Boolean isLoggedIn, Timestamp lastSeen, Timestamp dateCreated) {
		super();
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.imageURL = imageURL;
		this.isActive = isActive;
		this.isLoggedIn = isLoggedIn;
		this.lastSeen = lastSeen;
		this.dateCreated = dateCreated;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", midName=" + midName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", imageURL=" + imageURL + ", isActive=" + isActive
				+ ", isLoggedIn=" + isLoggedIn + ", lastSeen=" + lastSeen + ", dateCreated=" + dateCreated + "]";
	}
	
	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Transient
	private Integer port;
	
	
}
