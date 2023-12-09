package com.example.coursemanager.controller;

import com.example.coursemanager.service.CourseService;
import com.example.coursemanager.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Service
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonServiceService;
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        lessonServiceService.deleteLesson(id);
        return "Home";
    }
}
