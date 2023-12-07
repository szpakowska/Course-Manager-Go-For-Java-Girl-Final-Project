package com.example.coursemanager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    private LocalDateTime localDateTime;

    private Duration duration;

    public Lesson(String subject, LocalDateTime localDateTime, Duration duration) {
        this.subject = subject;
        this.localDateTime = localDateTime;
        this.duration = duration;
    }
}
