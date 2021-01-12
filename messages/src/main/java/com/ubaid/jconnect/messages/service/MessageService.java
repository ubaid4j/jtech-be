package com.ubaid.jconnect.messages.service;

import com.ubaid.jconnect.messages.entity.Message;

import java.util.List;

public interface MessageService {
	List<Message> getAllBySessionId(Long sessionId);
	Message saveMessage(Message message);
	List<Message> updateMessages(List<Message> messages);
	/**
	 * 
	 * @param sessionId sessionId
	 * @param userId userId
	 * @return all messages of the session and user id which is not received to the counter part session partner
	 */
	List<Message> getReceivedMessages(Long sessionId, Long userId);

}
