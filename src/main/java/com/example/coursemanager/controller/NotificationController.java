package com.example.coursemanager.controller;

import com.example.coursemanager.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user/notification")
@Controller
@Slf4j
@RequiredArgsConstructor
public class NotificationController {
    private NotificationService notificationService;
}
