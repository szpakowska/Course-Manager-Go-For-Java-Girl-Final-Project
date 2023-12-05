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

    @DeleteMapping
    public String deleteCourse(@RequestParam Long id) {
        courseService.deleteCourse(id);
        return "Home";
    }

    @GetMapping
    public String getCourses(@RequestParam(required = false) Long userId, Model model) {
        List<Course> coursesList;
        if (userId == null) {
            coursesList = courseService.getAllCourses();
        } else {
            coursesList = courseService.getCoursesByUserId();
        }
        model.addAttribute("coursesList", coursesList);

        System.out.println(coursesList); // delete this line!
        return "Home";
    }

    @GetMapping("/{id}")
    public String getCourseById(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "Home";
    }

    @PatchMapping("/{id}")
    public String addBlockToCourse(@PathVariable Long id, @RequestParam String blockName) {
        courseService.addBlockToCourse(id, blockName);
        return "Home";
    }


}






