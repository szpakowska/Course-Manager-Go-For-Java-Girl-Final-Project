package com.example.coursemanager.service;

import com.example.coursemanager.model.Course;
import com.example.coursemanager.model.User;
import com.example.coursemanager.repository.CourseJpaRepository;
import com.example.coursemanager.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseStudentsService {

    private final CourseJpaRepository courseJpaRepository;
    private final UserJpaRepository userJpaRepository;

    public void addStudentsToCourse(@PathVariable Long courseId, @RequestParam Long studentId) {
        Course course = courseJpaRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        User student = userJpaRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));

        List<User> students = course.getStudents();
        if (students == null) {
            students = new ArrayList<>(List.of(student));
        }
        else {
            if (students.contains(student)) {
                throw new RuntimeException("Student already assigned to this course");
            }
            students.add(student);
        }

        course.setStudents(students);
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
