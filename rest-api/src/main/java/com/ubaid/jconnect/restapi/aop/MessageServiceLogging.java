package com.ubaid.jconnect.restapi.aop;

import com.ubaid.jconnect.restapi.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@Aspect
public class MessageServiceLogging extends TargetMethods {

    @Around("addMessageBySessionId()")
    public Message logAddMessageBySessionIdMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Long sessionId = (Long) args[0];
        Message message = (Message) args[1];
        try {
            log.info("Creating Notification for Message {} of Session Id {}", message, sessionId);
            message = (Message) joinPoint.proceed();
            log.info("Notification Created for message {} of session id {}", message, sessionId);
            return message;
        } catch (Exception exp) {
            log.error("Exception [{}] Occurred in creating notification of message {} of session id {}", exp.getMessage(), message, sessionId);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("getAllReceivedMessage()")
    public List<?> logGetAllReceivedMessagesMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Long sessionId = (Long) args[0];
        Long userId = (Long) args[1];
        try {
            log.info("Finding all messages of the session id {} and user id  {} which is not received to the counter part session partner", sessionId, userId);
            List<?> messages = (List<?>) joinPoint.proceed();
            log.info("Got {} messages from session id {} && user id {}", messages.size(), sessionId, userId);
            return messages;
        } catch (Exception exp) {
            log.error("Exception [{}] occurred during getting all received messages by session id {} and user id {}", exp.getMessage(), sessionId, userId);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("getConversationBySessionId()")
    public List<?> logGetConversationBySessionIdMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Long sessionId = (Long) args[0];
        try {
            log.info("Getting all conversation of Session Id {}", sessionId);
            List<?> conversation = (List<?>) joinPoint.proceed();
            log.info("Got Conversation [{}] of session id {}", conversation, sessionId);
            return conversation;
        } catch (Exception exp) {
            log.error("Exception [{}] occurred during getting conversation of session id {}", exp.getMessage(), sessionId);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("saveMessage()")
    public Message logSaveMessageMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Message message = (Message) args[0];
        try {
            log.info("Saving Message in database {}", message);
            message = (Message) joinPoint.proceed();
            log.info("Message {} saved in database", message);
            return message;
        } catch (Exception exp) {
            log.error("Exception [{}] occurred during message {} saving in database", exp.getMessage(), message);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("updateReceivedMessages()")
    public List<?> logUpdateMessagesMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        List<?> messages = (List<?>) args[0];
        long[] messageIds = null;
        try {
            messageIds = messages.stream().mapToLong(message -> {
                Message msg = (Message) message;
                return msg.getId();
            }).toArray();
            log.info("Updating {} messages of Ids {}", messages.size(), messageIds);

            List<?> updatedMessages = (List<?>) joinPoint.proceed();
            messageIds = updatedMessages.stream().mapToLong(message -> {
                Message msg = (Message) message;
                return msg.getId();
            }).toArray();
            log.info("Updated {} messages of ids {}", updatedMessages.size(), messageIds);
            return updatedMessages;
        } catch (Exception exp) {
            log.error("Exception [{}] occurred during updating {} messages of ids {}", exp.getMessage(), messages.size(), messageIds);
            throw new RuntimeException(exp.getMessage());
        }
    }

}
