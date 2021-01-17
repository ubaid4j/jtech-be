package com.ubaid.jconnect.messages.aop;

import com.ubaid.jconnect.messages.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@Aspect
public class Logging extends TargetMethods {

    @Around("getAllBySessionId()")
    public List<?> logGetAllBySessionIdMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Long sessionId = (Long) args[0];
        try {
            log.info("Finding all messages by session id {}", sessionId);
            List<?> messages = (List<?>) joinPoint.proceed();
            log.info("Got {} messages from session id {}", messages.size(), sessionId);
            return messages;
        } catch (Exception exp) {
            log.error("Exception [{}] Occurred during getting all messages by session id {}", exp.getMessage(), sessionId);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("getReceivedMessages()")
    public List<?> logGetReceivedMessagesMethod(ProceedingJoinPoint joinPoint) throws Throwable {
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

    @Around("saveMessage()")
    public Message logSaveMessageMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Message message = (Message) args[0];
        try {
            log.info("Saving message {}", message);
            message = (Message) joinPoint.proceed();
            log.info("Message saved with id {}", message.getId());
            return message;
        } catch (Exception exp) {
            log.error("Exception [{}] occurred during saving message {}", exp.getMessage(), message);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("updateMessages()")
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
