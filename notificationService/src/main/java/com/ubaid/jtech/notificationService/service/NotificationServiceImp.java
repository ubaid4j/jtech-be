package com.ubaid.jtech.notificationService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.jtech.notificationService.dao.NotificationRepo;
import com.ubaid.jtech.notificationService.entity.Notification;
import com.ubaid.jtech.notificationService.service.def.NotificationService;

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
