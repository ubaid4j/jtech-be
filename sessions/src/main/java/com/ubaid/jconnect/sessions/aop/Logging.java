package com.ubaid.jconnect.sessions.aop;

import com.ubaid.jconnect.sessions.entity.Session;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Aspect
@Slf4j
public class Logging extends TargetMethods {

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

    @Around("getSessionsByUserId()")
    public List<?> logGetSessionByUserIdMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Long userId = (Long) args[0];
        try {
            log.info("Finding Sessions by user id {}", userId);
            List<?> sessions = (List<?>) joinPoint.proceed();
            long [] sessionsIds = sessions.stream().mapToLong(s -> {
                Session session = (Session) s;
                return session.getId();
            }).toArray();
            log.info("Got Sessions {} by user id {}", Arrays.toString(sessionsIds), userId);
            return sessions;
        } catch (Exception exp) {
            log.error("Exception [{}] happened during finding sessions by user id {}", exp.getMessage(), userId);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("updateSession()")
    public Session logUpdateSessionMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Session session = (Session) args[0];
        try {
            log.info("Updating Session [{}]", session);
            session = (Session) joinPoint.proceed();
            log.info("Session [{}] updated", session);
            return session;
        } catch (Exception exp) {
            log.error("Exception [{}] happened during updating session [{}]", exp.getMessage(), session);
            throw new RuntimeException(exp.getMessage());
        }
    }

}
