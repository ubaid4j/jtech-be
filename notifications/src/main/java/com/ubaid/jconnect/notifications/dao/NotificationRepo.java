package com.ubaid.jconnect.notifications.dao;

import java.util.List;

import com.ubaid.jconnect.notifications.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {
	
	@Query(value = "select * from notification where receiver_id = :userId and is_seen is false", nativeQuery = true)
	List<Notification> getAllNotSeenNotificationsOfUser(@Param("userId") Long id);
	
	@Transactional
	@Modifying
	@Query(value = "update notification set is_seen = true where receiver_id = :userId and session_id = :sessionId", nativeQuery = true)
	Integer updateUnSeenNotifications(@Param("userId") Long userId, @Param("sessionId") Long sessionId);
}
