package com.example.coursemanager.controller;

import com.example.coursemanager.dto.NotificationDto;
import com.example.coursemanager.model.Notification;
import com.example.coursemanager.model.User;
import com.example.coursemanager.service.NotificationService;
//import com.example.coursemanager.service.UserNotificationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/lesson/notification")
@Controller
@Slf4j
@RequiredArgsConstructor
public class NotificationController {
    private NotificationService notificationService;
  //  private UserNotificationService userNotificationService;

    @GetMapping("/add")
    public String showUserAdditionPage(Model model) {
        model.addAttribute("notificationDto", new NotificationDto());
        return "user/Notification";
    }

    @PostMapping("/add")
    public ResponseEntity<NotificationDto> addNotification(@RequestBody NotificationDto notificationDto) {
        try {
            NotificationDto addNotification = notificationService.addNotification(notificationDto);
            return ResponseEntity.ok(addNotification);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/edit")
    public String showNotificationEditionPage(Model model) {
        model.addAttribute("notificationDto", new NotificationDto());
        return "user/Notification";
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Notification> updateNotification(@RequestBody NotificationDto notificationDto, @PathVariable Long id) {
        try {
            Notification updateNotification = notificationService.updateNotification(notificationDto, id);
            return ResponseEntity.ok(updateNotification);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id){
        try {
            notificationService.deleteNotification(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public String showNotificationsForLesson(Model model, Long lessonId) {
        List<Notification> notificationList = notificationService.getNotificationsForLesson(lessonId);
        model.addAttribute("notificationList", notificationList);
        return "user/Notification";}
}
