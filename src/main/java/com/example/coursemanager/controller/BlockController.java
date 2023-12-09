package com.example.coursemanager.controller;

import com.example.coursemanager.service.BlockService;
import com.example.coursemanager.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Service
@RequiredArgsConstructor
public class BlockController {

    private final BlockService blockServiceService;
    @DeleteMapping("/{id}")
    public String deleteBlock(@PathVariable Long id) {
        blockServiceService.deleteBlock(id);
        return "Home";
    }
}
