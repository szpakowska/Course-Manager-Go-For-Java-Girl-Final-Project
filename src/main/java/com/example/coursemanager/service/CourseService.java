package com.example.coursemanager.service;

import com.example.coursemanager.model.Block;
import com.example.coursemanager.model.Course;
import com.example.coursemanager.repository.CourseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

    public List<Course> getCoursesByUserId() {
        return courseJpaRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseJpaRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void addBlockToCourse(Long courseId, String blockName) {
        Block block = new Block(blockName);
        Course course = courseJpaRepository.findById(courseId).orElseThrow(RuntimeException::new);
        if (course.getBlocks() == null) {
            course.setBlocks(new HashSet<>(List.of(block)));
        } else {
            course.getBlocks().add(block);
        }

        courseJpaRepository.save(course);
    }
}
