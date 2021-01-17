package com.ubaid.jconnect.restapi.controller;

import java.util.List;

import com.ubaid.jconnect.restapi.model.Message;
import com.ubaid.jconnect.restapi.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("jtech/messages")
@CrossOrigin("*")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    /**
     * @param sessionId sessionId
     * @return all messages by session id
     */
    @GetMapping("session/{sessionId}")
    public ResponseEntity<List<Message>> getConversationBySessionId(@PathVariable("sessionId") Long sessionId) {
        return new ResponseEntity<>(messageService.getConversationBySessionId(sessionId), HttpStatus.OK);
    }

    @PostMapping("session/{sessionId}")
    public ResponseEntity<Message> addMessageBySessionId(@PathVariable("sessionId") Long sessionId,
                                                         @RequestBody Message message) {
        return new ResponseEntity<>(messageService.addMessageBySessionId(sessionId, message), HttpStatus.ACCEPTED);
    }

    /**
     * @param sessionId sessionId
     * @param userId    userId
     * @return all messages having received id null
     */
    @GetMapping("session/{sessionId}/user/{userId}")
    public ResponseEntity<List<Message>> getReceivedMessages(@PathVariable("sessionId") Long sessionId, @PathVariable("userId") Long userId) {
        return new ResponseEntity<>(messageService.getAllReceivedMessage(sessionId, userId), HttpStatus.OK);
    }


    @PutMapping("session")
    public ResponseEntity<List<Message>> updateMessages(@RequestBody List<Message> messages) {
        List<Message> updatedMessages = messageService.updateReceivedMessages(messages);
        return ResponseEntity.ok(updatedMessages);
    }
}
