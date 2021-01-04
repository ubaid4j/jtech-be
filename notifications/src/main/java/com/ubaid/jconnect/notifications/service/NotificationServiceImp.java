package com.ubaid.jconnect.notifications.service;

import java.util.ArrayList;
import java.util.List;

import com.ubaid.jconnect.notifications.service.def.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.jconnect.notifications.dao.NotificationRepo;
import com.ubaid.jconnect.notifications.entity.Notification;

@Service
public class NotificationServiceImp implements NotificationService
{

	@Autowired
	private NotificationRepo repo;
	
	@Override
	public Notification saveOrUpdateNofication(Notification notification)
	{
		return repo.save(notification);
	}

	@Override
	public List<Notification> getAllUnseenNotificationsOfUser(Long userId) {
		return repo.getAllNotSeenNotificationsOfUser(userId);
	}

	@Override
	public List<Notification> setAllUnseenNotificationsSeen(Long userId, Long sessionId) {
		repo.updateUnSeenNotifications(userId, sessionId);
		return new ArrayList<Notification>();
	}

}
