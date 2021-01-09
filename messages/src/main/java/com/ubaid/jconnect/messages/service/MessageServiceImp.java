package com.ubaid.jconnect.messages.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.ubaid.jconnect.messages.service.def.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ubaid.jconnect.messages.dao.MessageRepo;
import com.ubaid.jconnect.messages.entity.Message;

@Service
@RequiredArgsConstructor
public class MessageServiceImp implements MessageService {
    private final MessageRepo repo;

    @Override
    public List<Message> getAllBySessionId(Long sessionId) {
        return repo.findAllBySessionId(sessionId);
    }

    @Override
    public Message saveMessage(Message message) {
        return repo.save(message);
    }

    @Override
    public List<Message> getReceivedMessages(Long sessionId, Long userId) {
        return repo.findReceivedMessage(sessionId, userId);
    }

    @Override
    public List<Message> updateMessages(List<Message> messages) {
        messages.forEach(m -> m.setReceivedTime(getCurrentTimestamp()));
        return repo.saveAll(messages);
    }

    private Timestamp getCurrentTimestamp() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }
}
