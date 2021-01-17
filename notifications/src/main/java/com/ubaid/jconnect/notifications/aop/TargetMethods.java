package com.ubaid.jconnect.notifications.aop;

import org.aspectj.lang.annotation.Pointcut;

public abstract class TargetMethods {

    @Pointcut("execution(* com.ubaid.jconnect.notifications.service.NotificationService.getAllUnseenNotificationsOfUser(Long))")
    public void getAllUnseenNotificationsOfUser() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.notifications.service.NotificationService.saveOrUpdateNotification(Long, Long))")
    public void saveOrUpdateNotification() {
    }

    @Pointcut("execution(* com.ubaid.jconnect.notifications.service.NotificationService.setAllUnseenNotificationsSeen(Long, Long))")
    public void setAllUnseenNotificationsSeen() {
    }
}