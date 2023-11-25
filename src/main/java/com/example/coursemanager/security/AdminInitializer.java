package com.example.coursemanager.security;

import com.example.coursemanager.model.User;
import com.example.coursemanager.repository.UserJpaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer {
    @Value("admin")
    private String adminUsername;
    @Value("admin")
    private String adminPassword;

    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminInitializer(UserJpaRepository userJpaRepository, PasswordEncoder passwordEncoder) {
        this.userJpaRepository = userJpaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initAdmin() {
        if (userJpaRepository.findByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername(adminUsername);
            admin.setPassword(passwordEncoder.encode(adminPassword));
            admin.setEmail("admin@coursemanager.com");
            admin.setRole(User.Role.ADMIN);

            userJpaRepository.save(admin);
        }
    }
}
