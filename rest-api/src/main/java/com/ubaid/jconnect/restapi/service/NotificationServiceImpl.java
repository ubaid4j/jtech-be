package com.ubaid.jconnect.restapi.service;

import com.ubaid.jconnect.restapi.feignProxy.NotificationProxy;
import com.ubaid.jconnect.restapi.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationProxy notificationProxy;

    @Override
    public Notification saveOrUpdateNotification(Notification notification) {
        return notificationProxy.saveOrUpdateNotification(notification);
    }

    @Override
    public List<Notification> getAllUnseenNotificationsByUser(Long userId) {
        return notificationProxy.getAllUnseenNotificationsByUser(userId);
    }

    @Override
    public List<Notification> updateAllUnseenNotificationsByUserAndSession(Long userId, Long sessionId) {
        return notificationProxy.updateAllUnseenNotificationsByUserAndSession(userId, sessionId);
    }
}
