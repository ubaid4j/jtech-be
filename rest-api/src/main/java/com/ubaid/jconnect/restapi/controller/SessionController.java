package com.ubaid.jconnect.restapi.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jconnect.restapi.feignProxy.SessionProxy;
import com.ubaid.jconnect.restapi.feignProxy.UserProxy;
import com.ubaid.jconnect.restapi.model.Session;
import com.ubaid.jconnect.restapi.model.User;

@RestController
@RequestMapping("jtech/sessions")
@CrossOrigin("*")
@RequiredArgsConstructor
public class SessionController {
    private final SessionProxy sessionProxy;
    private final UserProxy userProxy;

    @GetMapping("/{senderId}")
    public ResponseEntity<List<Session>> getSessionsBySenderId(@PathVariable("senderId") Long senderId) {
        List<Session> sessions = sessionProxy.getSessionsBySenderId(senderId);
        List<User> users = userProxy.getUsers();
        sessions.parallelStream().forEach(s -> {
            s.setSender(users);
            s.setReceiver(users);
        });
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @GetMapping("/{sessionId}/user/{userId}/active/{active}")
    public ResponseEntity<Session> setUserActive(@PathVariable("sessionId") Long sessionId,
                                                 @PathVariable("userId") Long userId, @PathVariable("active") Boolean active) {
        return ResponseEntity.ok(sessionProxy.setUserActive(sessionId, userId, active));
    }

    @PostMapping("")
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        System.err.println(session);
        return ResponseEntity.ok(sessionProxy.createSession(session));
    }

}
