package com.example.coursemanager.service;

import com.example.coursemanager.model.Notification;
import com.example.coursemanager.model.User;
import com.example.coursemanager.repository.NotificationJpaRepository;
import com.example.coursemanager.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserNotificationService {
    private final NotificationJpaRepository notificationJpaRepository;
    private final UserJpaRepository userJpaRepository;

    public void markNotificationAsRead(Long id) {
        Optional<Notification> userNotification = notificationJpaRepository.findById(id);
        userNotification.ifPresent(notification -> {
            notification.setIsRead(true);
            notificationJpaRepository.save(notification);
        });
    }

    public List<Notification> getNotificationsForUser(Long userId) {
        Optional<User> user = userJpaRepository.findById(userId);

        if (user.isPresent()) {
            return notificationJpaRepository.findNotificationsByUserIdAndSortByRead(userId);
        } else {
            return Collections.emptyList();
        }
    }
}
