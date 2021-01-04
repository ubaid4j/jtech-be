package com.ubaid.jconnect.sessions.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.ubaid.jconnect.sessions.service.def.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.jconnect.sessions.dao.SessionRepo;
import com.ubaid.jconnect.sessions.entity.Session;

@Service
public class SessionServiceImp implements SessionService
{

	@Autowired
	private SessionRepo sessionRepo;
	
	@Override
	public List<Session> getSessionsByUserId(Long id)
	{
		return sessionRepo.findAllByUserId(id);
	}

	@Override
	public Session getSessionById(Long sessionId) {
		return sessionRepo.findById(sessionId).get();
	}

	@Override
	public Session updateSession(Session session) {
		return sessionRepo.save(session);
	}

	@Override
	public Session createSession(Session session) {
		session.setIsReceiverActive(false);
		session.setIsSenderActive(false);
		session.setInitiateTime(new Timestamp((new Date()).getTime()));
		return sessionRepo.save(session);
	}

}
