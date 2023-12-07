package com.example.coursemanager.dto;

import com.example.coursemanager.model.Lesson;
//import com.example.coursemanager.model.UserNotification;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class NotificationDto {
    private Long id;
    private String subject;
    private String content;
    private LocalDateTime createdAt;
    private Set<Lesson> lessons;
   // private Set<UserNotification> userNotifications;
}
