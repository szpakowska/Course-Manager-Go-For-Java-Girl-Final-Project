package com.example.coursemanager.dto;

import com.example.coursemanager.model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
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
}
