package com.ubaid.jtech.sessionService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jtech.sessionService.entity.Session;
import com.ubaid.jtech.sessionService.service.def.SessionService;

import org.springframework.core.env.Environment;

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

}
