package com.example.coursemanager.service;

import com.example.coursemanager.model.Course;
import com.example.coursemanager.model.User;
import com.example.coursemanager.repository.CourseJpaRepository;
import com.example.coursemanager.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseStudentsService {

    private final CourseJpaRepository courseJpaRepository;
    private final UserJpaRepository userJpaRepository;

    public void addStudentsToCourse(Long courseId, Set<Long> studentIds) {
        Set<User> students = new HashSet<>(userJpaRepository.findAllById(studentIds));
        Course course = courseJpaRepository.findById(courseId).orElseThrow(RuntimeException::new);

        if (course.getStudents() == null) {
            course.setStudents(students);
        } else {
            course.getStudents().addAll(students);
        }
        courseJpaRepository.save(course);
    }

    public void deleteStudentFromCourse(Long courseId, Long studentId) {
        Course course = courseJpaRepository.findById(courseId).orElseThrow(RuntimeException::new);
        Optional.ofNullable(course.getStudents())
                .orElseThrow(RuntimeException::new)
                .removeIf(student -> student.getId().equals(studentId));
        courseJpaRepository.save(course);
    }
}
