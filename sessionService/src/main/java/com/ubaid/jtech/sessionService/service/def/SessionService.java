package com.ubaid.jtech.sessionService.service.def;

import java.util.List;

import com.ubaid.jtech.sessionService.entity.Session;

public interface SessionService
{
	/**
	 * 
	 * @param id
	 * @return all session related to this user, A given user is the 
	 * 			owner of this session if it is sender of this session
	 */
	public List<Session> getSessionsByUserId(Long id);
	
}
