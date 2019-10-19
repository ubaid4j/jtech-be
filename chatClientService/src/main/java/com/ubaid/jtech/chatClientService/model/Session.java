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
	private Boolean isReceiverActive;
	private Boolean isSenderActive;
	private Timestamp lastTimeActive;
	private Timestamp initiateTime;
	private Integer port;
	private User sender;
	@JsonProperty("receiver")
	private User receiver;

	/*--------------------------------Don't Alter------------------------------------------------------------*/
	public void setSender(List<User> senders) {
		this.sender = senders.parallelStream().filter(p -> p.getId() == getSenderId()).findAny().orElse(null);
	}
	public User getReciever() {
		return receiver;
	}
	public void setReciever(List<User> recievers) {
		this.receiver = recievers.parallelStream().filter(p -> p.getId() == getReceiverId()).findAny().orElse(null);
	}
	/*--------------------------------------------------------------------------------------------------------*/

	
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
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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
	public User getSender() {
		return sender;
	}
	
	public Session() {
		super();
	}
	public Session(Long senderId, Long receiverId, Boolean isActive, Boolean isReceiverActive, Boolean isSenderActive,
			Timestamp lastTimeActive, Timestamp initiateTime, Integer port, User sender, User receiver) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.isActive = isActive;
		this.isReceiverActive = isReceiverActive;
		this.isSenderActive = isSenderActive;
		this.lastTimeActive = lastTimeActive;
		this.initiateTime = initiateTime;
		this.port = port;
		this.sender = sender;
		this.receiver = receiver;
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", senderId=" + senderId + ", receiverId=" + receiverId + ", isActive=" + isActive
				+ ", isReceiverActive=" + isReceiverActive + ", isSenderActive=" + isSenderActive + ", lastTimeActive="
				+ lastTimeActive + ", initiateTime=" + initiateTime + ", port=" + port + ", sender=" + sender
				+ ", receiver=" + receiver + "]";
	}
	
	
}
