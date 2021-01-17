package com.ubaid.jconnect.restapi.aop;

import com.ubaid.jconnect.restapi.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Slf4j
public class NotificationServiceLogging extends TargetMethods {

    @Around("getAllUnseenNotificationsByUser()")
    public List<?> logGetAllBySessionIdMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Long userId = (Long) args[0];
        try {
            log.info("Finding all unseen notifications of user id {}", userId);
            List<?> notifications = (List<?>) joinPoint.proceed();
            log.info("Got {} unseen notifications of user id {}", notifications.size(), userId);
            return notifications;
        } catch (Exception exp) {
            log.error("Exception [{}] Occurred during getting all unseen notifications of user id {}", exp.getMessage(), userId);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("saveOrUpdateNotification()")
    public Notification logGetReceivedMessagesMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Notification notification = (Notification) args[0];
        try {
            log.info("saving notification [{}]", notification);
            notification = (Notification) joinPoint.proceed();
            log.info("Notification [{}] saved with id {}", notification, notification.getId());
            return notification;
        } catch (Exception exp) {
            log.error("Exception [{}] occurred during saving notification [{}]", exp.getMessage(), notification);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("updateAllUnseenNotificationsByUserAndSession()")
    public List<?> logSaveMessageMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Long userId = (Long) args[0];
        Long sessionId = (Long) args[1];
        try {
            log.info("Setting all notifications seen of user id {} and session id {}", userId, sessionId);
            List<?> seenNotifications = (List<?>) joinPoint.proceed();
            log.info("Set {} notifications seen", seenNotifications.size());
            return seenNotifications;
        } catch (Exception exp) {
            log.error("Exception [{}] occurred during setting unseen notifications to see of user id {} and session id {}", exp.getMessage(), userId, sessionId);
            throw new RuntimeException(exp.getMessage());
        }
    }

}
