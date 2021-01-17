package com.ubaid.jconnect.sessions.aop;

import org.aspectj.lang.annotation.Pointcut;

public class TargetMethods {

    @Pointcut("execution(* com.ubaid.jconnect.sessions.service.def.SessionService.createSession(com.ubaid.jconnect.sessions.entity.Session))")
    public void createSession() {}

    @Pointcut("execution(* com.ubaid.jconnect.sessions.service.def.SessionService.getSessionById(Long))")
    public void getSessionById() {}

    @Pointcut("execution(* com.ubaid.jconnect.sessions.service.def.SessionService.getSessionsByUserId(Long))")
    public void getSessionsByUserId() {}

    @Pointcut("execution(* com.ubaid.jconnect.sessions.service.def.SessionService.updateSession(com.ubaid.jconnect.sessions.entity.Session))")
    public void updateSession() {}
}
