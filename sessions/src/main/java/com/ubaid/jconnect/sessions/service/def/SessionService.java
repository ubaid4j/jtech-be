package com.ubaid.jconnect.sessions.service.def;

import java.util.List;

import com.ubaid.jconnect.sessions.entity.Session;

public interface SessionService {
    /**
     * @param id id
     * @return all session related to this user, A given user is the
     * owner of this session if it is sender of this session
     */
    List<Session> getSessionsByUserId(Long id);

    Session getSessionById(Long sessionId);

    Session updateSession(Session session);

    Session createSession(Session session);

}
