package com.ubaid.jconnect.restapi.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jconnect.restapi.model.Session;
import com.ubaid.jconnect.restapi.service.SessionService;

@RestController
@RequestMapping("jtech/sessions")
@CrossOrigin("*")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping("/{senderId}")
    public ResponseEntity<List<Session>> getSessionsBySenderId(@PathVariable("senderId") Long senderId) {
        return ResponseEntity.ok(sessionService.getSessionsBySenderId(senderId));
    }

    @GetMapping("/{sessionId}/user/{userId}/active/{active}")
    public ResponseEntity<Session> setUserActive(@PathVariable("sessionId") Long sessionId,
                                                 @PathVariable("userId") Long userId, @PathVariable("active") Boolean active) {
        return ResponseEntity.ok(sessionService.setUserActive(sessionId, userId, active));
    }

    @PostMapping("")
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        return ResponseEntity.ok(sessionService.createSession(session));
    }

}
