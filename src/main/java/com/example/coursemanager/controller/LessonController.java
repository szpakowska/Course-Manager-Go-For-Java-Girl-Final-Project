package com.example.coursemanager.controller;

import com.example.coursemanager.dto.LessonDto;
import com.example.coursemanager.dto.UserDto;
import com.example.coursemanager.model.Lesson;
import com.example.coursemanager.model.User;
import com.example.coursemanager.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;
    @PostMapping("delete/{id}")
    public String deleteLesson(@PathVariable Long id) {
            lessonService.deleteLesson(id);
            return "redirect:/lessons/management";
    }


    @GetMapping("/management")
    public String getAllLessons(Model model) {
        List<Lesson> lessonsList;

        lessonsList = lessonService.getAllLessons();
        model.addAttribute("lessonsList", lessonsList);

        return "admin/lesson/LessonManagement";
    }

    @GetMapping("manage/{lessonId}")
    public String getLessonById(@PathVariable Long lessonId, Model model) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        LessonDto lessonDto = new LessonDto(
                lesson.getSubject(),
                lesson.getLocalDateTime(),
                (int) lesson.getDuration().toMinutes()
        );
        model.addAttribute("lessonDto", lessonDto);
        return "admin/lesson/LessonEdition";
    }
    @PostMapping("/edit/{id}")
    public String updateLesson(@ModelAttribute("lessonDto") LessonDto lessonDto, @PathVariable Long id) {
        try {
            lessonService.updateLesson(lessonDto, id);
            return "redirect:/lessons/management";
        } catch (RuntimeException e) {
            // Obsługa błędu
            return "redirect:/lessons/management"; // lub inna obsługa błędu
        }
    }


}
