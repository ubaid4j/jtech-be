package com.ubaid.jconnect.restapi.service;

import com.ubaid.jconnect.restapi.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getConversationBySessionId(Long sessionId);
    Message addMessageBySessionId(Long sessionId, Message message);
    Message saveMessage(Message message);
    List<Message> getAllReceivedMessage(Long sessionId, Long userId);
    List<Message> updateReceivedMessages(List<Message> messages);
}
