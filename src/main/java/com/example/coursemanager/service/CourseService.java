package com.example.coursemanager.service;

import com.example.coursemanager.model.Course;
import com.example.coursemanager.repository.CourseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseJpaRepository courseJpaRepository;


    public void addCourse(String name) {
        Course course = new Course(name);
        courseJpaRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseJpaRepository.deleteById(id);
    }

    public List<Course> getAllCourses() {
        return courseJpaRepository.findAll();
    }

    public List<Course> getCoursesByUserId(Long userId) {
        return courseJpaRepository.findCoursesByUserId(userId);
    }

    public Course getCourseById(Long id) {
        return courseJpaRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
