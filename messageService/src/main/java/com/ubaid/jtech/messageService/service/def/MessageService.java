package com.ubaid.jtech.messageService.service.def;

import com.ubaid.jtech.messageService.entity.Message;

import java.util.List;

public interface MessageService {
	public List<Message> getAllBySessionId(Long sessionId);
	public Message saveMessage(Message message);
}
