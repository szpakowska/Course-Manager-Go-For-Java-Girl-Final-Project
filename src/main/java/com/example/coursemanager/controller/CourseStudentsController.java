package com.example.coursemanager.controller;

import com.example.coursemanager.service.CourseStudentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/courses")
@Controller
@Slf4j
@RequiredArgsConstructor
public class CourseStudentsController {

    private final CourseStudentsService courseStudentsService;


    @PatchMapping("/{courseId}/students")
    public String addStudentsToCourse(@PathVariable Long courseId, @RequestParam Set<Long> studentIds) {
        courseStudentsService.addStudentsToCourse(courseId, studentIds);
        return "Home";
    }

    @DeleteMapping("/{courseId}/students/{studentId}")
    public String removeStudentsFromCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        courseStudentsService.deleteStudentFromCourse(courseId, studentId);
        return "Home";
    }



}






