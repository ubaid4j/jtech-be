package com.ubaid.jtech.chatClientService.feignProxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ubaid.jtech.chatClientService.model.Notification;

@FeignClient(contextId = "notification-service-client", name = "api-gateway-server")
@RibbonClient(name = "notification-service") 
public interface NotificationProxy {
	@PostMapping("notification-service/jtech/notifications/")
	public Notification saveOrUpdateNotification(@RequestBody Notification notification);
	
	@GetMapping("notification-service/jtech/notifications/by/user/{userId}")
	public List<Notification> getAllUnseenNotificationsByUser(@PathVariable("userId") Long userId);

	@GetMapping("notification-service/jtech/notifications/update/by/user/{userId}/session/{sessionId}")	
	public List<Notification> updateAllUnseenNotificationsByUserAndSession(@PathVariable("userId") Long userId, @PathVariable("sessionId") Long sessionId);
}
