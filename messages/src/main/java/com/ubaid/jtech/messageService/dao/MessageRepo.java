package com.ubaid.jtech.messageService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ubaid.jtech.messageService.entity.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {

	@Query(value = "select * from message where session_id = :sessionId and receieved_time is not null", nativeQuery = true)
	List<Message> findAllBySessionId(@Param("sessionId") Long sessionId);
	
	@Query(value = "select * from message where session_id = :sessionId and owner_id = :userId and receieved_time is null order by sent_time;", nativeQuery = true)
	List<Message> findRecievedMessage(@Param("sessionId") Long sessionId, @Param("userId") Long userId);
}
