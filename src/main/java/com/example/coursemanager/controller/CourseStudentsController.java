package com.example.coursemanager.controller;

import com.example.coursemanager.service.CourseStudentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/courses")
@Controller
@Slf4j
@RequiredArgsConstructor
public class CourseStudentsController {

    private final CourseStudentsService courseStudentsService;


    @PostMapping("/{courseId}/students")
    public String addStudentsToCourse(@PathVariable Long courseId, @RequestParam Long studentId) {
        courseStudentsService.addStudentsToCourse(courseId, studentId);
        return "redirect:/courses/manage/" + courseId;
    }

    @PostMapping("/{courseId}/students/{studentId}")
    public String removeStudentsFromCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        courseStudentsService.deleteStudentFromCourse(courseId, studentId);
        return "redirect:/courses/manage/" + courseId;
    }



}






