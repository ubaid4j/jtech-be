package com.ubaid.jtech.messageService.entity;

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
public class Message {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long sessionId;
	
	@Column
	private String text;
	
	@Column
	private Timestamp sentTime;

	@Column
	private Timestamp receievedTime;
	
	@Column
	private Timestamp seenTime;
	
	@Column
	private Long ownerId;
	
	@Transient
	private Integer port;

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getSentTime() {
		return sentTime;
	}

	public void setSentTime(Timestamp sentTime) {
		this.sentTime = sentTime;
	}

	public Timestamp getRecievedTime() {
		return receievedTime;
	}

	public void setRecievedTime(Timestamp recievedTime) {
		this.receievedTime = recievedTime;
	}

	public Timestamp getSeenTime() {
		return seenTime;
	}

	public void setSeenTime(Timestamp seenTime) {
		this.seenTime = seenTime;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Message(Long sessionId, String text, Timestamp sentTime, Timestamp recievedTime, Timestamp seenTime,
			Long ownerId, Integer port) {
		super();
		this.sessionId = sessionId;
		this.text = text;
		this.sentTime = sentTime;
		this.receievedTime = recievedTime;
		this.seenTime = seenTime;
		this.ownerId = ownerId;
		this.port = port;
	}

	public Message() {
		super();
	}
	
}
