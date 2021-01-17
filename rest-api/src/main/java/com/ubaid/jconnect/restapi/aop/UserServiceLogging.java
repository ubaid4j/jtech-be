package com.ubaid.jconnect.restapi.aop;

import com.ubaid.jconnect.restapi.model.AuthUser;
import com.ubaid.jconnect.restapi.model.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
@Slf4j
public class UserServiceLogging extends TargetMethods {

    @Around("createUser()")
    public User logCreateUserMethod(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        AuthUser authUser = (AuthUser) args[0];
        try {
            log.info("Create User {}", authUser);
            User user = (User) joinPoint.proceed();
            log.info("User Created {}", user);
            return user;
        } catch(Throwable exp) {
            log.error("Exception [{}] occurred  in creating User {}", exp.getMessage(), authUser);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("getUsers()")
    public List<?> logGetUsersMethod(ProceedingJoinPoint joinPoint) {
        try {
            log.info("Finding All Users");
            List<?> users = (List<?>) joinPoint.proceed();
            long[] userIds = users.stream().mapToLong(u -> {
                User user = (User) u;
                return user.getId();
            }).toArray();
            log.info("Found Users {}", Arrays.toString(userIds));
            return users;
        } catch(Throwable exp) {
            log.error("Exception [{}] occurred  in finding all users", exp.getMessage());
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("getUserByEmail()")
    public User logGetUserByEmailMethod(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String email = (String) args[0];
        try {
            log.info("Finding a user by email {}", email);
            User user = (User) joinPoint.proceed();
            log.info("Found a user {} by email {}", user, email);
            return user;
        } catch(Throwable exp) {
            log.error("Exception [{}] occurred in finding a user by email {}", exp.getMessage(), email);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("getUserById()")
    public User logFindByIdMethod(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Long userId = (Long) args[0];
        try {
            log.info("Finding a user by userId {}", userId);
            User user = (User) joinPoint.proceed();
            log.info("Found a user {} by userId {}", user, userId);
            return user;
        } catch(Throwable exp) {
            log.error("Exception [{}] occurred in finding a user by userId {}", exp.getMessage(), userId);
            throw new RuntimeException(exp.getMessage());
        }
    }

    @Around("authUser()")
    public User logFindUserByEmailAndPasswordMethod(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        AuthUser authUser = (AuthUser) args[0];
        try {
            log.info("Finding a user by email {} and password {}", authUser.getEmail(), authUser.getPassword());
            User user = (User) joinPoint.proceed();
            log.info("Found a user {} by email {} and password {}", user, authUser.getEmail(), authUser.getPassword());
            return user;
        } catch(Throwable exp) {
            log.error("Exception [{}] occurred in finding a user by email {} and password {}", exp.getMessage(), authUser.getEmail(), authUser.getPassword());
            throw new RuntimeException(exp.getMessage());
        }
    }
}
