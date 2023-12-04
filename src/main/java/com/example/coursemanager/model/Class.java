package com.example.coursemanager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String subject;

    private LocalDateTime dateTime;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> students;

    @ManyToOne
    private User lecturer;

}
