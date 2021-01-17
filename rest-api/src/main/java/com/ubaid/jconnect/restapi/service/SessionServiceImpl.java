package com.ubaid.jconnect.restapi.service;

import com.ubaid.jconnect.restapi.feignProxy.SessionProxy;
import com.ubaid.jconnect.restapi.feignProxy.UserProxy;
import com.ubaid.jconnect.restapi.model.Session;
import com.ubaid.jconnect.restapi.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionProxy sessionProxy;
    private final UserProxy userProxy;


    @Override
    public List<Session> getSessionsBySenderId(Long senderId) {
        List<Session> sessions = sessionProxy.getSessionsBySenderId(senderId);
        List<User> users = userProxy.getUsers();
        sessions.parallelStream().forEach(s -> {
            s.setSender(users);
            s.setReceiver(users);
        });
        return sessions;
    }

    @Override
    public Session setUserActive(Long sessionId, Long userId, Boolean active) {
        return sessionProxy.setUserActive(sessionId, userId, active);
    }

    @Override
    public Session getSessionById(Long sessionId) {
        return sessionProxy.getSessionById(sessionId);
    }

    @Override
    public Session createSession(Session session) {
        return sessionProxy.createSession(session);
    }
}
