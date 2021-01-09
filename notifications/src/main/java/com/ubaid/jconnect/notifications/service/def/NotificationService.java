package com.ubaid.jconnect.notifications.service.def;

import java.util.List;

import com.ubaid.jconnect.notifications.entity.Notification;

public interface NotificationService {
	Notification saveOrUpdateNotification(Notification notification);
	List<Notification> getAllUnseenNotificationsOfUser(Long userId);
	List<Notification> setAllUnseenNotificationsSeen(Long userId, Long sessionId);
}
