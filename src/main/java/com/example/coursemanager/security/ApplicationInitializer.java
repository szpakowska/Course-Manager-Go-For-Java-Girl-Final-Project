package com.example.coursemanager.security;

import com.example.coursemanager.model.Role;
import com.example.coursemanager.model.User;
import com.example.coursemanager.repository.RoleJpaRepository;
import com.example.coursemanager.repository.UserJpaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ApplicationInitializer {
    @Value("${application.admin.username}")
    private String adminUsername;
    @Value("${application.admin.password}")
    private String adminPassword;

    private final UserJpaRepository userJpaRepository;
    private final RoleJpaRepository roleJpaRepository;

    private final PasswordEncoder passwordEncoder;

    public ApplicationInitializer(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository, PasswordEncoder passwordEncoder) {
        this.userJpaRepository = userJpaRepository;
        this.roleJpaRepository = roleJpaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initApplication() {
        if (roleJpaRepository.findByName("Admin") == null) {
            roleJpaRepository.deleteAll();
            userJpaRepository.deleteAll();

            initRoles();
            initAdminUser();
        }

    }

    private void initRoles() {
        Set<Role> roles = Set.of(
                new Role("Admin"),
                new Role("Student"),
                new Role("Lecturer")
        );
        roleJpaRepository.saveAll(roles);
    }

    private void initAdminUser() {
        User admin = new User();
        admin.setUsername(adminUsername);
        admin.setPassword(passwordEncoder.encode(adminPassword));
        admin.setEmail("admin@coursemanager.com");
        admin.setName("Jan");
        admin.setSurname("Kowalski");
        admin.setActive(true);
        admin.setRoles(Set.of(roleJpaRepository.findByName("Admin")));

        userJpaRepository.save(admin);

    }


}
