package com.example.coursemanager.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity(name = "user_account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "active")
    private Boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @ManyToMany(mappedBy = "users")
    private Set<Lesson> lessons;

    @OneToMany(mappedBy = "user")
    private Set<UserNotification> userNotifications;
}
