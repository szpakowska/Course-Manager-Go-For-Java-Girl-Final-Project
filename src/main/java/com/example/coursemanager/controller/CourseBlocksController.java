package com.example.coursemanager.controller;

import com.example.coursemanager.service.CourseBlocksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/courses")
@Controller
@Slf4j
@RequiredArgsConstructor
public class CourseBlocksController {

    private final CourseBlocksService courseBlocksService;

    @PatchMapping("/{courseId}/blocks")
    public String addBlockToCourse(@PathVariable Long courseId, @RequestParam String blockName) {
        courseBlocksService.addBlockToCourse(courseId, blockName);
        return "Home";
    }

    @DeleteMapping("/{courseId}/blocks/{blockId}")
    public String removeBlockFromCourse(@PathVariable Long courseId, @PathVariable Long blockId) {
        courseBlocksService.removeBlockFromCourse(courseId, blockId);
        return "Home";
    }

}






