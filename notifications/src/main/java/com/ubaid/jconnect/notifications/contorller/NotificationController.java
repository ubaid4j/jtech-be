package com.ubaid.jconnect.notifications.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jconnect.notifications.entity.Notification;
import com.ubaid.jconnect.notifications.service.def.NotificationService;

@RestController
@RequestMapping("/jtech/notifications")
public class NotificationController
{
	@Autowired
	private NotificationService service;
	
	@PostMapping("/")
	public ResponseEntity<Notification> saveOrUpdateNotification(@RequestBody Notification notification)
	{
		return ResponseEntity.ok(service.saveOrUpdateNofication(notification));
	}
	
	@GetMapping("by/user/{userId}")
	public ResponseEntity<List<Notification>> getAllUnseenNotificationsByUserId(@PathVariable("userId") Long userId)
	{
		return ResponseEntity.ok(service.getAllUnseenNotificationsOfUser(userId));
	}
	
	@GetMapping("/update/by/user/{userId}/session/{sessionId}")
	public ResponseEntity<List<Notification>> setAllUnseenNotificationSeen(@PathVariable("userId") Long userId, @PathVariable("sessionId") Long sessionId)
	{
		System.err.println(userId);
		System.err.println(sessionId);
		return ResponseEntity.ok(service.setAllUnseenNotificationsSeen(userId, sessionId));
	}
}
