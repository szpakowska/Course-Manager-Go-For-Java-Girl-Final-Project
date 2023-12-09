package com.example.coursemanager.controller;

import com.example.coursemanager.model.Course;
import com.example.coursemanager.service.NotificationService;
import com.example.coursemanager.service.UserNotificationService;
import com.example.coursemanager.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


//    @PostMapping("/mark-as-read/{userNotificationId}")
//    public ResponseEntity<Void> markNotificationAsRead(@PathVariable Long userNotificationId) {
//        userNotificationService.markNotificationAsRead(userNotificationId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
