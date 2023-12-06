package com.example.coursemanager.service;

import com.example.coursemanager.repository.NotificationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationJpaRepository notificationJpaRepository;
}
