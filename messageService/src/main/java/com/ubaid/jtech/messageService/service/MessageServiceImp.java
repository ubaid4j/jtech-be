package com.ubaid.jtech.messageService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.jtech.messageService.dao.MessageRepo;
import com.ubaid.jtech.messageService.entity.Message;
import com.ubaid.jtech.messageService.service.def.MessageService;

@Service
public class MessageServiceImp implements MessageService
{

	@Autowired
	private MessageRepo repo;
	
	@Override
	public List<Message> getAllBySessionId(Long sessionId)
	{
		return repo.findAllBySessionId(sessionId);
	}

	@Override
	public Message saveMessage(Message message)
	{
		return repo.save(message);
	}

	@Override
	public List<Message> getReceivedMessages(Long sessionId, Long userId) {
		return repo.findRecievedMessage(sessionId, userId);
	}

}
