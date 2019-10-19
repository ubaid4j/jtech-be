package com.ubaid.jtech.messageService.service.def;

import com.ubaid.jtech.messageService.entity.Message;

import java.util.List;

public interface MessageService {
	public List<Message> getAllBySessionId(Long sessionId);
	public Message saveMessage(Message message);
	public List<Message> updateMessages(List<Message> messages);
	/**
	 * 
	 * @param sessionId
	 * @param userId
	 * @return all messages of the session and user id which is not received to the counter part session partner
	 */
	public List<Message> getReceivedMessages(Long sessionId, Long userId);

}
