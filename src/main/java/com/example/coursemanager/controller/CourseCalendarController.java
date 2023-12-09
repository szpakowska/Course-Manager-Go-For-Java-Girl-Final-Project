package com.example.coursemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseCalendarController {
    @GetMapping("/calendar")
    public String showCalendar() {
        return "/student/Calendar";
    }
}
