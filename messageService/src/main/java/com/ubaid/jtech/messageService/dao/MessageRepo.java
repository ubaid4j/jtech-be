package com.ubaid.jtech.messageService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubaid.jtech.messageService.entity.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {
	List<Message> findAllBySessionId(Long sessionId);	
}
