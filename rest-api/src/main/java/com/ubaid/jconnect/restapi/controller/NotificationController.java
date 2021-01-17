package com.ubaid.jconnect.restapi.controller;

import java.util.List;

import com.ubaid.jconnect.restapi.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jconnect.restapi.model.Notification;

@RestController
@RequestMapping("jtech/notifications")
@CrossOrigin("*")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/by/user/{userId}")
    public ResponseEntity<List<Notification>> getAllUnseenNotificationsByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(notificationService.getAllUnseenNotificationsByUser(userId));
    }

    @GetMapping("update/by/user/{userId}/session/{sessionId}")
    public ResponseEntity<List<Notification>> updateAllUnseenNotificationsByUserAndSession(@PathVariable("userId") Long userId, @PathVariable("sessionId") Long sessionId) {
        return ResponseEntity.ok(notificationService.updateAllUnseenNotificationsByUserAndSession(userId, sessionId));
    }

}
