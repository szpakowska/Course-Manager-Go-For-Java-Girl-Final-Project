package com.example.coursemanager.dto;

import com.example.coursemanager.model.Lesson;
import com.example.coursemanager.model.Notification;
import com.example.coursemanager.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;
    private Boolean active;
    private Set<Role> roles;
    private Set<Lesson> lessons;
    private Set<Notification> notifications;
}
