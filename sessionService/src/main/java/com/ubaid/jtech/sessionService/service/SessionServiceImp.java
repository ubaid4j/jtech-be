package com.ubaid.jtech.sessionService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.jtech.sessionService.dao.SessionRepo;
import com.ubaid.jtech.sessionService.entity.Session;
import com.ubaid.jtech.sessionService.service.def.SessionService;

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

}
