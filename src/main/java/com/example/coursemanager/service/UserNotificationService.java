package com.example.coursemanager.service;

import com.example.coursemanager.repository.UserNotificationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserNotificationService {
    private final UserNotificationJpaRepository userNotificationJpaRepository;
}
