package com.ubaid.jconnect.messages.dao;

import java.util.List;

import com.ubaid.jconnect.messages.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessageRepo extends JpaRepository<Message, Long> {

	@Query(value = "select * from message where session_id = :sessionId and receieved_time is not null", nativeQuery = true)
	List<Message> findAllBySessionId(@Param("sessionId") Long sessionId);
	
	@Query(value = "select * from message where session_id = :sessionId and owner_id = :userId and receieved_time is null order by sent_time;", nativeQuery = true)
	List<Message> findReceivedMessage(@Param("sessionId") Long sessionId, @Param("userId") Long userId);
}
