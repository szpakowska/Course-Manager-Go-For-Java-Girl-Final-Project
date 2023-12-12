package com.example.coursemanager.service;

import com.example.coursemanager.model.Lesson;
import com.example.coursemanager.repository.LessonJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonJpaRepository lessonJpaRepository;

    public void deleteLesson(Long id) {
        lessonJpaRepository.deleteById(id);
    }

    public List<Lesson> getAllLessons() {return lessonJpaRepository.findAll();
    }

    public Lesson getLessonById(Long id) {return lessonJpaRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
