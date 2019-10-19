package com.ubaid.jtech.notificationService.service.def;

import java.util.List;

import com.ubaid.jtech.notificationService.entity.Notification;

public interface NotificationService {
	public Notification saveOrUpdateNofication(Notification notification);
	public List<Notification> getAllUnseenNotificationsOfUser(Long userId);
	public List<Notification> setAllUnseenNotificationsSeen(Long userId, Long sessionId);
}
