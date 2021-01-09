package com.ubaid.jconnect.restapi.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.ubaid.jconnect.restapi.feignProxy.MessageProxy;
import com.ubaid.jconnect.restapi.feignProxy.NotificationProxy;
import com.ubaid.jconnect.restapi.feignProxy.SessionProxy;
import com.ubaid.jconnect.restapi.model.Message;
import com.ubaid.jconnect.restapi.model.Session;
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

import com.ubaid.jconnect.restapi.model.Notification;


@RestController
@RequestMapping("jtech/messages")
@CrossOrigin("*")
@RequiredArgsConstructor
public class MessageController {
    private final MessageProxy messageProxy;
    private final SessionProxy sessionProxy;
    private final NotificationProxy notificationProxy;

    /**
     * @param sessionId sessionId
     * @return all messages by session id
     */
    @GetMapping("session/{sessionId}")
    public ResponseEntity<List<Message>> getConversationBySessionId(@PathVariable("sessionId") Long sessionId) {
        List<Message> conversation = messageProxy.getConversationBySessionId(sessionId);
        conversation.forEach(System.err::println);
        return new ResponseEntity<>(conversation, HttpStatus.OK);
    }

    @PostMapping("session/{sessionId}")
    public ResponseEntity<Message> addMessageBySessionId(@PathVariable("sessionId") Long sessionId,
                                                         @RequestBody Message message) {
        message.setSessionId(sessionId);
        message.setSentTime(getCurrentTimestamp());
        message = messageProxy.saveMessage(message);
        //here we will store notification
        Session session = sessionProxy.getSessionById(sessionId);
        if (!session.getIsSenderActive() || !session.getIsReceiverActive()) {
            Notification notification = new Notification();
            notification.setIsSeen(false);
            notification.setMessageId(message.getId());
            notification.setSessionId(sessionId);
            notification.setSenderId(message.getOwnerId());
            Long ownerOfMessage = message.getOwnerId();
            if (ownerOfMessage.equals(session.getSenderId())) {
                notification.setReceiverId(session.getReceiverId());
            } else if (ownerOfMessage.equals(session.getReceiverId())) {
                notification.setReceiverId(session.getSenderId());
            }
            System.err.println(notification);
            notificationProxy.saveOrUpdateNotification(notification);
        }
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    /**
     * @param sessionId sessionId
     * @param userId userId
     * @return all messages having received id null
     */
    @GetMapping("session/{sessionId}/user/{userId}")
    public ResponseEntity<List<Message>> getReceivedMessages(@PathVariable("sessionId") Long sessionId, @PathVariable("userId") Long userId) {
        return new ResponseEntity<>(messageProxy.getAllReceivedMessage(sessionId, userId), HttpStatus.OK);
    }

    private Timestamp getCurrentTimestamp() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    @PutMapping("session")
    public ResponseEntity<List<Message>> updateMessages(@RequestBody List<Message> messages) {
        List<Message> updatedMessages = messageProxy.updateReceivedMessages(messages);
        updatedMessages.forEach(System.err::println);
        return ResponseEntity.ok(updatedMessages);
    }
}
