package com.example.coursemanager.controller;

import com.example.coursemanager.service.BlockLecturerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/blocks")
@Controller
@Slf4j
@RequiredArgsConstructor
public class BlockLecturerController {

    private final BlockLecturerService blockLecturerService;

    @PostMapping("/{blockId}/lecturer/{lecturerId}")
    public String addLecturerToBlock(@PathVariable Long blockId, @PathVariable Long lecturerId) {
        blockLecturerService.addLecturerToBlock(blockId, lecturerId);
        return "Home";
    }

    @PostMapping("remove/{blockId}/lecturer/{lecturerId}")
    public String removeLecturerFromBlock(@PathVariable Long blockId, @PathVariable Long lecturerId) {
        blockLecturerService.removeLecturerFromBlock(blockId, lecturerId);
        return "Home";
    }

}






