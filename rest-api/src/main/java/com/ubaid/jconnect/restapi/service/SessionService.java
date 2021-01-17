package com.ubaid.jconnect.restapi.service;

import com.ubaid.jconnect.restapi.model.Session;

import java.util.List;

public interface SessionService {
    List<Session> getSessionsBySenderId(Long senderId);
    Session setUserActive(Long sessionId, Long userId, Boolean active);
    Session getSessionById(Long sessionId);
    Session createSession(Session session);

}
