package com.ubaid.jtech.chatClientService.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jtech.chatClientService.feignProxy.MessageProxy;
import com.ubaid.jtech.chatClientService.model.Message;

@RestController
@RequestMapping("jtech/messages")
@CrossOrigin("*")
public class MessageController
{
	@Autowired
	private MessageProxy messageProxy;
	
	@GetMapping("session/{sessionId}")
	public ResponseEntity<List<Message>> getConversationBySessionId(@PathVariable("sessionId") Long sessionId)
	{
		return new ResponseEntity<List<Message>>(messageProxy.getConversationBySessionId(sessionId), HttpStatus.OK);
	}

	@PostMapping("session/{sessionId}")
	public ResponseEntity<Message> addMessageBySessionId(@PathVariable("sessionId") Long sessionId,
			@RequestBody Message message)
	{
		message.setSessionId(sessionId);
		message.setSentTime(getCurrentTimestamp());
		return new ResponseEntity<Message>(messageProxy.saveMessage(message), HttpStatus.ACCEPTED);
	}
	
	//List<Message> getRecievedMessage using session/{sessionId}/user/{ownerId}
	@GetMapping("session/{sessionId}/user/{userId}")
	public ResponseEntity<List<Message>> getReceivedMessages(@PathVariable("sessionId") Long sessionId, @PathVariable("userId") Long userId)
	{	
		return new ResponseEntity<List<Message>>(messageProxy.getAllReceivedMessage(sessionId, userId), HttpStatus.OK);
	}
	
	private Timestamp getCurrentTimestamp()
	{
		Date date= new Date();		 
		Timestamp ts = new Timestamp(date.getTime());
		return ts;
	}
}
