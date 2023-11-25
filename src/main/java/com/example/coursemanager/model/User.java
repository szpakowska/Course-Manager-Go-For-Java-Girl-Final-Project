package com.example.coursemanager.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;


import java.util.Collection;
import java.util.Objects;
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

//nie korzystać z pola 'role' w User, tylko zrobić osobną klasę i po ID przypisujemy to użytkownika
    @Column(name = "role", columnDefinition = "ENUM('ADMIN', 'LECTURER', 'STUDENT')")
    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }


    public enum Role {
        ADMIN, LECTURER, STUDENT
    }
}
