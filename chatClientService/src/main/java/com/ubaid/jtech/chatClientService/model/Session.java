package com.ubaid.jtech.chatClientService.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Session
{
	private Long id;	
	private Long senderId;
	@JsonProperty("receiverId")
	private Long receiverId;
	private Boolean isActive;
	private Timestamp lastTimeActive;
	private Timestamp initiateTime;
	private Integer port;
	private User sender;
	@JsonProperty("receiver")
	private User receiver;
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
		return receiverId;
	}
	public void setRecieverId(Long recieverId) {
		this.receiverId = recieverId;
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
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(List<User> senders) {
		this.sender = senders.parallelStream().filter(p -> p.getId() == getSenderId()).findAny().orElse(null);
	}
	public User getReciever() {
		return receiver;
	}
	public void setReciever(List<User> recievers) {
		this.receiver = recievers.parallelStream().filter(p -> p.getId() == getRecieverId()).findAny().orElse(null);
	}
	public Session(Long senderId, Long recieverId, Boolean isActive, Timestamp lastTimeActive, Timestamp initiateTime,
			Integer port, User sender, User reciever) {
		super();
		this.senderId = senderId;
		this.receiverId = recieverId;
		this.isActive = isActive;
		this.lastTimeActive = lastTimeActive;
		this.initiateTime = initiateTime;
		this.port = port;
		this.sender = sender;
		this.receiver = reciever;
	}
	public Session() {
		super();
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", senderId=" + senderId + ", receiverId=" + receiverId + ", isActive=" + isActive
				+ ", lastTimeActive=" + lastTimeActive + ", initiateTime=" + initiateTime + ", port=" + port
				+ ", sender=" + sender + ", receiver=" + receiver + "]";
	}
	
}
