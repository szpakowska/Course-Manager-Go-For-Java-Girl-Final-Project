//package com.example.coursemanager.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@Entity
//public class UserNotification {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "notification_id")
//    @OrderBy("read ASC, notificationCreatedAt DESC")
//    private Notification notification;
//
//    private boolean read;
//}
