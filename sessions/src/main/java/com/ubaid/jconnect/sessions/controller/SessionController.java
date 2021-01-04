package com.ubaid.jconnect.sessions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jconnect.sessions.entity.Session;
import com.ubaid.jconnect.sessions.service.def.SessionService;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/jtech/sessions")
public class SessionController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private SessionService sessionService;
	/**
	 * 
	 * @return all sessions of given user id
	 */
	@GetMapping("/{senderId}")
	public List<Session> getSessionsByUserId(@PathVariable("senderId") Long userId)
	{
		int port = Integer.parseInt(env.getProperty("local.server.port"));
		List<Session> sessions = sessionService.getSessionsByUserId(userId);
		sessions.stream().forEach(s -> s.setPort(port));
		return sessions;
	}
	
	@GetMapping("/{sessionId}/user/{userId}/active/{active}")
	public ResponseEntity<Session> setUserActive(@PathVariable("sessionId") Long sessionId,
			@PathVariable("userId") Long userId, @PathVariable("active") Boolean active)
	{
		Session session = sessionService.getSessionById(sessionId);
		if (session.getReceiverId() == userId) {
			session.setIsReceiverActive(active);
		} else if (session.getSenderId() == userId) {
			session.setIsSenderActive(active);
		}
		session = sessionService.updateSession(session);
		return ResponseEntity.ok(session);
	}
	
	@GetMapping("by/session/{sessionId}")
	public ResponseEntity<Session> getSessionById(@PathVariable("sessionId") Long sessionId)
	{
		Session session = sessionService.getSessionById(sessionId);
		return ResponseEntity.ok(session);
	}
	
	
	@PostMapping("")
	public ResponseEntity<Session> createSession(@RequestBody Session session)
	{
		System.err.println(session);
		return ResponseEntity.ok(sessionService.createSession(session));
	}

}
