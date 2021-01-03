package com.ubaid.jtech.notificationService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Notification
{
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long sessionId;
	
	@Column
	private Long messageId;
	
	@Column
	private Long receiverId;
	
	@Column
	private Long senderId;
	
	@Column
	private Boolean isSeen;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Boolean getIsSeen() {
		return isSeen;
	}

	public void setIsSeen(Boolean isSeen) {
		this.isSeen = isSeen;
	}

	public Notification(Long sessionId, Long messageId, Long receiverId, Long senderId, Boolean isSeen) {
		super();
		this.sessionId = sessionId;
		this.messageId = messageId;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.isSeen = isSeen;
	}

	public Notification() {
		super();
	}
	@Override
	public String toString() {
		return "Notification [sessionId=" + sessionId + ", messageId=" + messageId + ", receiverId=" + receiverId
				+ ", senderId=" + senderId + ", isSeen=" + isSeen + "]";
	}
}
