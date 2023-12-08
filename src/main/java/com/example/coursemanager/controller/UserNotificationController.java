package com.example.coursemanager.controller;

import com.example.coursemanager.dto.NotificationDto;
import com.example.coursemanager.dto.UserDto;
import com.example.coursemanager.model.Notification;
import com.example.coursemanager.model.UserNotification;
import com.example.coursemanager.service.NotificationService;
import com.example.coursemanager.service.UserNotificationService;
import com.example.coursemanager.service.UserService;
import com.example.coursemanager.utils.mapper.UserMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user/notification")
@Controller
@Data
@RequiredArgsConstructor
public class UserNotificationController {
    private UserNotificationService userNotificationService;
    private NotificationService notificationService;
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserNotification>> getNotificationsForUser(@PathVariable Long userId) {
        List<UserNotification> unreadNotifications = userNotificationService.getNotificationsForUser(userId);
        return new ResponseEntity<>(unreadNotifications, HttpStatus.OK);
    }

    @PostMapping("/mark-as-read/{userNotificationId}")
    public ResponseEntity<Void> markNotificationAsRead(@PathVariable Long userNotificationId) {
        userNotificationService.markNotificationAsRead(userNotificationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
