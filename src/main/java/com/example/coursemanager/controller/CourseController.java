package com.example.coursemanager.controller;

import com.example.coursemanager.model.Course;
import com.example.coursemanager.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/courses")
@Controller
@Slf4j
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public String addCourse(@RequestParam String name) {
        courseService.addCourse(name);
        return "Home";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Home";
    }

    @GetMapping
    public String getCourses(@RequestParam(required = false) Long userId, Model model) {
        List<Course> coursesList;
        if (userId == null) {
            coursesList = courseService.getAllCourses();
        } else {
            coursesList = courseService.getCoursesByUserId(userId);
        }
        model.addAttribute("coursesList", coursesList);

        return "Home";
    }

    @GetMapping("/{courseId}")
    public String getCourseById(@PathVariable Long courseId, Model model) {
        Course course = courseService.getCourseById(courseId);
        model.addAttribute("course", course);
        return "Home";
    }



}






