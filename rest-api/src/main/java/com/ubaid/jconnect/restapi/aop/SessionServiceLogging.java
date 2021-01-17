package com.ubaid.jconnect.restapi.aop;

import com.ubaid.jconnect.restapi.model.Session;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Aspect
@Component
@Slf4j
public class SessionServiceLogging extends TargetMethods {

    @Around("createSession()")
    public Session logCreateSessionMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Session session = (Session) args[0];

        try {
            log.info("Creating Session [{}]", session);
            session = (Session) joinPoint.proceed();
            log.info("Session [{}] created", session);
            return session;
        } catch (Exception exp) {
            log.error("Exception [{}] happened during session creation", exp.getMessage());
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("getSessionById()")
    public Session logGetSessionByIdMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Long sessionId = (Long) args[0];
        try {
            log.info("Finding Session by session id {}", sessionId);
            Session session = (Session) joinPoint.proceed();
            log.info("Got Session [{}] by session id {}", session, sessionId);
            return session;
        } catch (Exception exp) {
            log.error("Exception [{}] happened during finding session by id {}", exp.getMessage(), sessionId);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("getSessionsBySenderId()")
    public List<?> logGetSessionByUserIdMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Long userId = (Long) args[0];
        try {
            log.info("Finding Sessions by sender id {}", userId);
            List<?> sessions = (List<?>) joinPoint.proceed();
            long [] sessionsIds = sessions.stream().mapToLong(s -> {
                Session session = (Session) s;
                return session.getId();
            }).toArray();
            log.info("Got Sessions {} by sender id {}", Arrays.toString(sessionsIds), userId);
            return sessions;
        } catch (Exception exp) {
            log.error("Exception [{}] happened during finding sessions by sender id {}", exp.getMessage(), userId);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("setUserActive()")
    public Session logSetUserActiveMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Long sessionId = (Long) args[0];
        Long userId = (Long) args[1];
        Boolean isActive = (Boolean) args[2];
        try {
            log.info("Setting user {} of session {} active {}", userId, sessionId, isActive);
            Session session = (Session) joinPoint.proceed();
            log.info("User active of session {}", session);
            return session;
        } catch (Exception exp) {
            log.error("Exception [{}] happened activating user {} of session id {}", exp.getMessage(), userId, sessionId);
            throw new RuntimeException(exp.getMessage());
        }
    }

}
