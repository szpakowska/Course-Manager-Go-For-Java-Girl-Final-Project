package com.example.coursemanager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String subject;

    @Column
    private String content;

    @Column
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    private Class className;
}
