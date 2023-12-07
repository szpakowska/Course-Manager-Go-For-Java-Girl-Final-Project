package com.example.coursemanager.utils.mapper;

import com.example.coursemanager.dto.NotificationDto;
import com.example.coursemanager.model.Notification;

public class NotificationMapper {
    public static Notification toNotificationModel(NotificationDto notificationDto) {
        Notification notification = new Notification();
        notification.setSubject(notificationDto.getSubject());
        notification.setContent(notificationDto.getContent());
        notification.setCreatedAt(notificationDto.getCreatedAt());
        notification.setLessons(notificationDto.getLessons());
//        notification.setUserNotifications(notificationDto.getUserNotifications());
        return notification;
    }

    public static NotificationDto toNotificationDto(Notification notification) {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setSubject(notification.getSubject());
        notificationDto.setContent(notification.getContent());
        notificationDto.setCreatedAt(notification.getCreatedAt());
        notificationDto.setLessons(notification.getLessons());
 //       notificationDto.setUserNotifications(notification.getUserNotifications());
        return notificationDto;
    }
}
