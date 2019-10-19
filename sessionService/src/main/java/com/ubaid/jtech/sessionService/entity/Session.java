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
	private Long receiverId;
	
	@Column
	private Boolean isReceiverActive;
	
	@Column 
	private Boolean isSenderActive;
	
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

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public Boolean getIsReceiverActive() {
		return isReceiverActive;
	}

	public void setIsReceiverActive(Boolean isReceiverActive) {
		this.isReceiverActive = isReceiverActive;
	}

	public Boolean getIsSenderActive() {
		return isSenderActive;
	}

	public void setIsSenderActive(Boolean isSenderActive) {
		this.isSenderActive = isSenderActive;
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

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Session() {
		super();
	}

	public Session(Long senderId, Long receiverId, Boolean isReceiverActive, Boolean isSenderActive,
			Timestamp lastTimeActive, Timestamp initiateTime, Integer port) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.isReceiverActive = isReceiverActive;
		this.isSenderActive = isSenderActive;
		this.lastTimeActive = lastTimeActive;
		this.initiateTime = initiateTime;
		this.port = port;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", senderId=" + senderId + ", receiverId=" + receiverId + ", isReceiverActive="
				+ isReceiverActive + ", isSenderActive=" + isSenderActive + ", lastTimeActive=" + lastTimeActive
				+ ", initiateTime=" + initiateTime + ", port=" + port + "]";
	}

}
