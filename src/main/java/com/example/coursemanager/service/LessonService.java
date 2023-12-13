package com.example.coursemanager.service;

import com.example.coursemanager.dto.LessonDto;
import com.example.coursemanager.model.Lesson;
import com.example.coursemanager.repository.LessonJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonJpaRepository lessonJpaRepository;

    public void deleteLesson(Long id) {
        lessonJpaRepository.deleteById(id);
    }

    public List<Lesson> getAllLessons() {
        return lessonJpaRepository.findAll();
    }

    public Lesson getLessonById(Long id) {
        return lessonJpaRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void updateLesson(LessonDto lessonDto, Long id) {
        Lesson lesson = lessonJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        lesson.setSubject(lessonDto.subject());
        lesson.setLocalDateTime(lessonDto.localDateTime());
        lesson.setDuration(Duration.ofMinutes(lessonDto.durationInMinutes()));

        lessonJpaRepository.save(lesson);
    }
}
