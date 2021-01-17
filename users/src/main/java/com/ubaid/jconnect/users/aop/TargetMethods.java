package com.ubaid.jconnect.users.aop;

import org.aspectj.lang.annotation.Pointcut;

public class TargetMethods {
    @Pointcut("execution(* com.ubaid.jconnect.users.service.def.UserService.createUser(com.ubaid.jconnect.users.entity.AuthUser))")
    public void createUser() {}

    @Pointcut("execution(* com.ubaid.jconnect.users.service.def.UserService.findAll())")
    public void findAll() {}

    @Pointcut("execution(* com.ubaid.jconnect.users.service.def.UserService.findByEmail(String))")
    public void findByEmail() {}

    @Pointcut("execution(* com.ubaid.jconnect.users.service.def.UserService.findById(Long))")
    public void findById() {}

    @Pointcut("execution(* com.ubaid.jconnect.users.service.def.UserService.findUserByEmailAndPasswor(String, String))")
    public void findUserByEmailAndPassword() {}
}
