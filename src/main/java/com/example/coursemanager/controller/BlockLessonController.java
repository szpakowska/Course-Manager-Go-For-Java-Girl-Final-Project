package com.example.coursemanager.controller;

import com.example.coursemanager.dto.LessonDto;
import com.example.coursemanager.model.Block;
import com.example.coursemanager.model.Lesson;
import com.example.coursemanager.service.BlockLessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/blocks")
@Controller
@Slf4j
@RequiredArgsConstructor
public class BlockLessonController {

    private final BlockLessonService blockLessonService;

    @PostMapping("/{blockId}/lesson")
    public String addLessonToBlock(@PathVariable Long blockId, @ModelAttribute LessonDto lessonDto) {
        blockLessonService.addLessonToBlock(blockId, lessonDto);
        return "redirect:/blocks/manage/" + blockId;
    }

    @PostMapping("/{blockId}/lesson/{lessonId}")
    public String removeLessonFromBlock(@PathVariable Long blockId, @PathVariable Long lessonId) {
        blockLessonService.removeLessonFromBlock(blockId, lessonId);
        return "redirect:/blocks/manage/" + blockId;
    }


}
