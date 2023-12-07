package com.example.coursemanager.repository;

import com.example.coursemanager.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LessonJpaRepository extends JpaRepository<Lesson, Long> {
    Optional<Lesson> findById(Long lessonId);

}
