package com.ubaid.jconnect.restapi.feignProxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ubaid.jconnect.restapi.model.Notification;

@FeignClient(contextId = "notification-service-client", name = "api-gateway")
public interface NotificationProxy {
    @PostMapping("jtech/notifications/")
    Notification saveOrUpdateNotification(@RequestBody Notification notification);

    @GetMapping("jtech/notifications/by/user/{userId}")
    List<Notification> getAllUnseenNotificationsByUser(@PathVariable("userId") Long userId);

    @GetMapping("jtech/notifications/update/by/user/{userId}/session/{sessionId}")
    List<Notification> updateAllUnseenNotificationsByUserAndSession(@PathVariable("userId") Long userId, @PathVariable("sessionId") Long sessionId);
}
