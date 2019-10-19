package com.ubaid.jtech.chatClientService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jtech.chatClientService.feignProxy.SessionProxy;
import com.ubaid.jtech.chatClientService.feignProxy.UserProxy;
import com.ubaid.jtech.chatClientService.model.Session;
import com.ubaid.jtech.chatClientService.model.User;

@RestController
@RequestMapping("jtech/sessions")
@CrossOrigin("*")
public class SessionController
{
	@Autowired
	private SessionProxy sessionProxy;
	
	@Autowired
	private UserProxy userProxy;
	
	@GetMapping("/{senderId}")
	public ResponseEntity<List<Session>> getSessionsBySenderId(@PathVariable("senderId") Long senderId)
	{
		List<Session> sessions = sessionProxy.getSessionsBySenderId(senderId);
		List<User> users = userProxy.getUsers();
		sessions.parallelStream().forEach(s -> {
			s.setSender(users);
			s.setReciever(users);
		});
		return new ResponseEntity<List<Session>>(sessions, HttpStatus.OK);
	}
	
	@GetMapping("/{sessionId}/user/{userId}/active/{active}")
	public ResponseEntity<Session> setUserActive(@PathVariable("sessionId") Long sessionId,
			@PathVariable("userId") Long userId, @PathVariable("active") Boolean active)
	{
		return ResponseEntity.ok(sessionProxy.setUserActive(sessionId, userId, active));
	}
	
}
