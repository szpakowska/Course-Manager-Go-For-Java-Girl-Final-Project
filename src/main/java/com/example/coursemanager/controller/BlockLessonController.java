package com.example.coursemanager.controller;

import com.example.coursemanager.dto.LessonDto;
import com.example.coursemanager.service.BlockLessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/blocks")
@Controller
@Slf4j
@RequiredArgsConstructor
public class BlockLessonController {

    private final BlockLessonService blockLessonService;

    @PatchMapping("/{blockId}/lesson")
    public String addLecturerToBlock(@PathVariable Long blockId, @RequestBody LessonDto lessonDto) {
        blockLessonService.addLessonToBlock(blockId, lessonDto);
        return "Home";
    }

    @DeleteMapping("/{blockId}/lesson/{lessonId}")
    public String removeLessonFromBlock(@PathVariable Long blockId, @PathVariable Long lessonId) {
        blockLessonService.removeLessonFromBlock(blockId, lessonId);
        return "Home";
    }


}