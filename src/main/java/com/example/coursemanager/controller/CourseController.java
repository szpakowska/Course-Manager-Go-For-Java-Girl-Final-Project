package com.example.coursemanager.controller;

import com.example.coursemanager.model.Course;
import com.example.coursemanager.security.model.ApplicationUserDetails;
import com.example.coursemanager.service.CourseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @PostMapping("/add")
    public String addCourse(@RequestParam String name) {
        courseService.addCourse(name);
        return "redirect:/courses/management";
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        try {
        courseService.deleteCourse(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public String getCourses(@AuthenticationPrincipal ApplicationUserDetails userDetails, @RequestParam(required = false) Long userId, Model model) {
        List<Course> coursesList;
        if (userId == null) {
            coursesList = courseService.getCoursesByUserId(userDetails.getUserId());
        } else {
            coursesList = courseService.getCoursesByUserId(userId);
        }
        model.addAttribute("coursesList", coursesList);

        return "CoursesAssigned";
    }

    @GetMapping("/management")
    public String getAllCourses(Model model) {
        List<Course> coursesList;

        coursesList = courseService.getAllCourses();
        model.addAttribute("coursesList", coursesList);

        return "admin/course/CourseManagement";
    }


    @GetMapping("manage/{courseId}")
    public String getCourseById(@PathVariable Long courseId, Model model) {
        Course course = courseService.getCourseById(courseId);
        model.addAttribute("course", course);
        return "admin/course/CourseInformation";
    }

    @GetMapping("/add")
    public String showCourseAdditionPage(Model model) {
        model.addAttribute("course", new Course());
        return "admin/course/CourseAddition";
    }
}






