//package com.example.coursemanager.service;
//
//import com.example.coursemanager.model.User;
//import com.example.coursemanager.model.UserNotification;
//import com.example.coursemanager.repository.UserJpaRepository;
//import com.example.coursemanager.repository.UserNotificationJpaRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UserNotificationService {
//    private final UserNotificationJpaRepository userNotificationJpaRepository;
//    private final UserJpaRepository userJpaRepository;
//
//    public void markNotificationAsRead(Long id) {
//        Optional<UserNotification> userNotification = userNotificationJpaRepository.findById(id);
//        userNotification.ifPresent(notification -> {
//            notification.setRead(true);
//            userNotificationJpaRepository.save(notification);
//        });
//    }
//
//    public List<UserNotification> getNotificationsForUser(Long userId) {
//        Optional<User> user = userJpaRepository.findById(userId);
//
//        if (user.isPresent()) {
//            return userNotificationJpaRepository.findByUserId(userId);
//        } else {
//            return Collections.emptyList();
//        }
//    }
//}
