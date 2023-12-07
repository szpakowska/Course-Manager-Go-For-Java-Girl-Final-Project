package com.example.coursemanager.dto;

import com.example.coursemanager.model.Lesson;

import java.time.Duration;
import java.time.LocalDateTime;

public record LessonDto(String subject, LocalDateTime localDateTime, Integer durationInMinutes) {

    public Lesson toLesson() {
        return new Lesson(subject, localDateTime, Duration.ofMinutes(durationInMinutes));
    }
}
