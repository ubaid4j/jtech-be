package com.ubaid.jconnect.messages.controller;

import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jconnect.messages.entity.Message;
import com.ubaid.jconnect.messages.service.def.MessageService;

@RestController
@RequestMapping("/jtech/messages")
@RequiredArgsConstructor
public class MessageController {

    private final Environment env;
    private final MessageService service;

    @GetMapping("/by/session/{id}")
    public ResponseEntity<List<Message>> getAllMessagesBySessionId(@PathVariable("id") Long id) {
        int port = Integer.parseInt(Objects.requireNonNull(env.getProperty("local.server.port")));
        List<Message> messages = service.getAllBySessionId(id);
        messages.parallelStream().forEach(m -> m.setPort(port));
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PostMapping("/by/session")
    public ResponseEntity<Message> saveMessage(@RequestBody Message message) {
        return new ResponseEntity<>(service.saveMessage(message), HttpStatus.OK);
    }

    @GetMapping("/by/session/{sessionId}/user/{userId}")
    public ResponseEntity<List<Message>> getAllReceivedMessage(@PathVariable("sessionId") Long sessionId,
															   @PathVariable("userId") Long userId) {
        return new ResponseEntity<>(service.getReceivedMessages(sessionId, userId), HttpStatus.OK);
    }

    @PutMapping("/by/session")
    public ResponseEntity<List<Message>> updateMessages(@RequestBody List<Message> messages) {
        return ResponseEntity.ok(service.updateMessages(messages));
    }
}
