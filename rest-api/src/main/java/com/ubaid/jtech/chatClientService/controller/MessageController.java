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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jtech.chatClientService.feignProxy.MessageProxy;
import com.ubaid.jtech.chatClientService.feignProxy.NotificationProxy;
import com.ubaid.jtech.chatClientService.feignProxy.SessionProxy;
import com.ubaid.jtech.chatClientService.model.Message;
import com.ubaid.jtech.chatClientService.model.Notification;
import com.ubaid.jtech.chatClientService.model.Session;


@RestController
@RequestMapping("jtech/messages")
@CrossOrigin("*")
public class MessageController
{
	@Autowired
	private MessageProxy messageProxy;
	
	@Autowired
	private SessionProxy sessionProxy;
	
	@Autowired
	private NotificationProxy notificationProxy;
	
	/**
	 * @param sessionId
	 * @return
	 */
	@GetMapping("session/{sessionId}")
	public ResponseEntity<List<Message>> getConversationBySessionId(@PathVariable("sessionId") Long sessionId)
	{
		List<Message> conversation = messageProxy.getConversationBySessionId(sessionId);
		conversation.forEach(m -> System.err.println(m));
		return new ResponseEntity<List<Message>>(conversation, HttpStatus.OK);
	}

	@PostMapping("session/{sessionId}")
	public ResponseEntity<Message> addMessageBySessionId(@PathVariable("sessionId") Long sessionId,
			@RequestBody Message message)
	{
		message.setSessionId(sessionId);
		message.setSentTime(getCurrentTimestamp());
		message = messageProxy.saveMessage(message);
		//here we will store notification
		Session session = sessionProxy.getSessionById(sessionId);
		if(!session.getIsSenderActive() || !session.getIsReceiverActive())
		{
			Notification notification = new Notification();
			notification.setIsSeen(false);
			notification.setMessageId(message.getId());
			notification.setSessionId(sessionId);
			notification.setSenderId(message.getOwnerId());
			Long ownerOfMessage = message.getOwnerId();
			if (ownerOfMessage.equals(session.getSenderId()))
			{
				notification.setReceiverId(session.getReceiverId());
			}
			else if (ownerOfMessage.equals(session.getReceiverId()))
			{
				notification.setReceiverId(session.getSenderId());
			}
			System.err.println(notification);
			notificationProxy.saveOrUpdateNotification(notification);
		}
		return new ResponseEntity<Message>(message, HttpStatus.ACCEPTED);
	}
	
	/**
	 * 
	 * @param sessionId
	 * @param userId
	 * @return all messages having received id null
	 */
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
	
	@PutMapping("session")
	public ResponseEntity<List<Message>> updateMessages(@RequestBody List<Message> messages)
	{
		List<Message> updatedMessages = messageProxy.updateReceivedMessages(messages);
		updatedMessages.forEach(m -> System.err.println(m));
		return ResponseEntity.ok(updatedMessages);
	}
}
