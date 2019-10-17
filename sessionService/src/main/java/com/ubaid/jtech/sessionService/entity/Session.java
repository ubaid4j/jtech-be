package com.ubaid.jtech.sessionService.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column
	public Long senderId;
	
	@Column
	public Long recieverId;
	
	@Column
	public Boolean isActive;
	
	@Column
	public Timestamp lastTimeActive;
	
	@Column
	public Timestamp initiateTime;
}
