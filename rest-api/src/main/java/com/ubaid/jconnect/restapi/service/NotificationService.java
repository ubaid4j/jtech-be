package com.ubaid.jconnect.restapi.service;

import com.ubaid.jconnect.restapi.model.Notification;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface NotificationService {
    Notification saveOrUpdateNotification(@RequestBody Notification notification);
    List<Notification> getAllUnseenNotificationsByUser(Long userId);
    List<Notification> updateAllUnseenNotificationsByUserAndSession(Long userId, Long sessionId);
}
