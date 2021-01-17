package com.ubaid.jconnect.restapi.service;

import com.ubaid.jconnect.restapi.feignProxy.MessageProxy;
import com.ubaid.jconnect.restapi.feignProxy.NotificationProxy;
import com.ubaid.jconnect.restapi.feignProxy.SessionProxy;
import com.ubaid.jconnect.restapi.model.Message;
import com.ubaid.jconnect.restapi.model.Notification;
import com.ubaid.jconnect.restapi.model.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageProxy messageProxy;
    private final SessionProxy sessionProxy;
    private final NotificationProxy notificationProxy;


    @Override
    public List<Message> getConversationBySessionId(Long sessionId) {
        List<Message> conversation = messageProxy.getConversationBySessionId(sessionId);
        log.info("Got {} messages for session Id {}", conversation.size(), sessionId);
        return conversation;
    }

    @Override
    public Message addMessageBySessionId(Long sessionId, Message message) {
        message.setSessionId(sessionId);
        message.setSentTime(getCurrentTimestamp());
        message = saveMessage(message);
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
            log.info("Notification: {}", notification);
            notificationProxy.saveOrUpdateNotification(notification);
        }

        return message;
    }

    @Override
    public Message saveMessage(Message message) {
        return messageProxy.saveMessage(message);
    }

    @Override
    public List<Message> getAllReceivedMessage(Long sessionId, Long userId) {
        return messageProxy.getAllReceivedMessage(sessionId, userId);
    }

    @Override
    public List<Message> updateReceivedMessages(List<Message> messages) {
        return messageProxy.updateReceivedMessages(messages);
    }

    private Timestamp getCurrentTimestamp() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

}
