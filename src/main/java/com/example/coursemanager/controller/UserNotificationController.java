package com.example.coursemanager.controller;

import com.example.coursemanager.service.UserNotificationService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/user/notification")
@Controller
@Data
@RequiredArgsConstructor
public class UserNotificationController {
    private UserNotificationService userNotificationService;


    @PostMapping("/mark-as-read/{userNotificationId}")
    public ResponseEntity<Void> markNotificationAsRead(@PathVariable Long userNotificationId) {
        userNotificationService.markNotificationAsRead(userNotificationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
