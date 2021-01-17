package com.ubaid.jconnect.messages.aop;

import org.aspectj.lang.annotation.Pointcut;

public abstract class TargetMethods {

    @Pointcut("execution(* com.ubaid.jconnect.messages.service.MessageService.getAllBySessionId(Long))")
    public void getAllBySessionId() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.messages.service.MessageService.getReceivedMessages(Long, Long))")
    public void getReceivedMessages() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.messages.service.MessageService.saveMessage(com.ubaid.jconnect.messages.entity.Message))")
    public void saveMessage() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.messages.service.MessageService.updateMessages(java.util.List<com.ubaid.jconnect.messages.entity.Message>))")
    public void updateMessages() {
    }
}