package com.ubaid.jconnect.restapi.aop;

import org.aspectj.lang.annotation.Pointcut;

public abstract class TargetMethods {

    //message services
    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.MessageService.addMessageBySessionId(Long, com.ubaid.jconnect.restapi.model.Message))")
    public void addMessageBySessionId() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.MessageService.getAllReceivedMessage(Long, Long))")
    public void getAllReceivedMessage() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.MessageService.getConversationBySessionId(Long))")
    public void getConversationBySessionId() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.MessageService.saveMessage(com.ubaid.jconnect.restapi.model.Message))")
    public void saveMessage() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.MessageService.updateReceivedMessages(java.util.List<com.ubaid.jconnect.restapi.model.Message>))")
    public void updateReceivedMessages() {
    }

    //notifications
    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.NotificationService.getAllUnseenNotificationsByUser(Long))")
    public void getAllUnseenNotificationsByUser() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.NotificationService.saveOrUpdateNotification(java.util.List<com.ubaid.jconnect.restapi.model.Notification>))")
    public void saveOrUpdateNotification() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.NotificationService.updateAllUnseenNotificationsByUserAndSession(Long, Long))")
    public void updateAllUnseenNotificationsByUserAndSession() {
    }

    //sessions
    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.SessionService.createSession(com.ubaid.jconnect.restapi.model.Session))")
    public void createSession() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.SessionService.getSessionById(Long))")
    public void getSessionById() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.SessionService.getSessionsBySenderId(Long))")
    public void getSessionsBySenderId() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.SessionService.setUserActive(Long, Long, Boolean))")
    public void setUserActive() {
    }

    //user service
    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.UserService.authUser(com.ubaid.jconnect.restapi.model.AuthUser))")
    public void authUser() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.UserService.createUser(com.ubaid.jconnect.restapi.model.AuthUser))")
    public void createUser() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.UserService.getUserById(Long))")
    public void getUserById() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.UserService.getUserByEmail(String))")
    public void getUserByEmail() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.restapi.service.UserService.getUsers())")
    public void getUsers() {
    }
}