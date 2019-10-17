package com.ubaid.jtech.sessionService.entity;

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
public class Session
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long senderId;
	
	@Column
	private Long recieverId;
	
	@Column
	private Boolean isActive;
	
	@Column
	private Timestamp lastTimeActive;
	
	@Column
	private Timestamp initiateTime;
	
	@Transient
	private Integer port;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getRecieverId() {
		return recieverId;
	}

	public void setRecieverId(Long recieverId) {
		this.recieverId = recieverId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getLastTimeActive() {
		return lastTimeActive;
	}

	public void setLastTimeActive(Timestamp lastTimeActive) {
		this.lastTimeActive = lastTimeActive;
	}

	public Timestamp getInitiateTime() {
		return initiateTime;
	}

	public void setInitiateTime(Timestamp initiateTime) {
		this.initiateTime = initiateTime;
	}

	public Session(Long senderId, Long recieverId, Boolean isActive, Timestamp lastTimeActive, Timestamp initiateTime) {
		super();
		this.senderId = senderId;
		this.recieverId = recieverId;
		this.isActive = isActive;
		this.lastTimeActive = lastTimeActive;
		this.initiateTime = initiateTime;
	}

	public Session() {
		super();
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", senderId=" + senderId + ", recieverId=" + recieverId + ", isActive=" + isActive
				+ ", lastTimeActive=" + lastTimeActive + ", initiateTime=" + initiateTime + ", port=" + port + "]";
	}
}
