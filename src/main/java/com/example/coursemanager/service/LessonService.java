package com.example.coursemanager.service;

import com.example.coursemanager.repository.LessonJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonJpaRepository lessonJpaRepository;

    public void deleteLesson(Long id) {
        lessonJpaRepository.deleteById(id);
    }
}
