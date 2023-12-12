package com.example.coursemanager.controller;

import com.example.coursemanager.model.Block;
import com.example.coursemanager.model.Course;
import com.example.coursemanager.service.BlockService;
import com.example.coursemanager.service.LessonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blocks")
@RequiredArgsConstructor
public class BlockController {

    private final BlockService blockService;
    @PostMapping("delete/{id}")
    public ResponseEntity<Void> deleteBlock(@PathVariable Long id) {
        try {
            blockService.deleteBlock(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("manage/{blockId}")
    public String getBlockById(@PathVariable Long blockId, Model model) {
        Block block = blockService.getBlockById(blockId);
        model.addAttribute("block", block);
        return "admin/block/BlockInformation";
    }


    @GetMapping("/management")
    public String getAllBlocks(Model model) {
        List<Block> blocksList;

        blocksList = blockService.getAllBlocks();
        model.addAttribute("blocksList", blocksList);

        return "admin/block/BlockManagement";

    }


}


