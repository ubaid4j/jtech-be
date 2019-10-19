package com.ubaid.jtech.chatClientService.model;

import java.sql.Timestamp;

public class Message
{
	private Long id;
	private Long sessionId;
	private String text;
	private Timestamp sentTime;
	private Timestamp receievedTime;
	private Timestamp seenTime;
	private Long ownerId;
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
	public Timestamp getReceievedTime() {
		return receievedTime;
	}
	public void setReceievedTime(Timestamp receievedTime) {
		this.receievedTime = receievedTime;
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
	public Message(Long sessionId, String text, Timestamp sentTime, Timestamp receievedTime, Timestamp seenTime,
			Long ownerId, Integer port) {
		super();
		this.sessionId = sessionId;
		this.text = text;
		this.sentTime = sentTime;
		this.receievedTime = receievedTime;
		this.seenTime = seenTime;
		this.ownerId = ownerId;
		this.port = port;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", sessionId=" + sessionId + ", text=" + text + ", sentTime=" + sentTime
				+ ", receievedTime=" + receievedTime + ", seenTime=" + seenTime + ", ownerId=" + ownerId + ", port="
				+ port + "]";
	}
	public Message() {
		super();
	}
	
	 

}
