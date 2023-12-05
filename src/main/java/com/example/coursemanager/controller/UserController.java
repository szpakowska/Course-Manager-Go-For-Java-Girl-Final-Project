package com.example.coursemanager.controller;

import com.example.coursemanager.dto.UserDto;
import com.example.coursemanager.model.User;
import com.example.coursemanager.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/user-addition")
    public String showUserAdditionPage() {
        return "admin/UserAddition";}

    @PostMapping("/user-addition")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        try {
            UserDto addUser = userService.addUser(userDto);
            return ResponseEntity.ok(addUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/user-edition")
    public String showUserEditionPage() {
        return "admin/UserEdition";}

    @GetMapping("/user-edition/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/user-edition/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        try {
            User updateUser = userService.updateUser(user);
            return ResponseEntity.ok(updateUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PatchMapping ("/user-surname-edition/{id}")
    public ResponseEntity<User> updateSurname(@PathVariable Long id, @RequestParam String surname) {
        try {
            User updateSurname = userService.updateSurname(id, surname);
            return ResponseEntity.ok(updateSurname);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping ("/user-email-edition/{id}")
    public ResponseEntity<User> updateEmail(@PathVariable Long id, @RequestParam String email) {
        try {
            User updateEmail = userService.updateEmail(id, email);
            return ResponseEntity.ok(updateEmail);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user-deletion")
    public String showUserDeletionPage() {
        return "admin/UserDeletion";}

    @DeleteMapping("/user-deletion/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/report-of-users")
    public String showReportOfUserPage(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("usersList", userList);
        return "admin/ReportOfUsers";}


    @GetMapping("/report-of-blocks")
    public String showReportOfBlocksPage() {
        return "admin/ReportOfBlocks";}

    @GetMapping("/course-edition")
    public String showCourseEditionPage() {
        return "admin/CourseEdition";}

    @GetMapping("/course-deletion")
    public String showCourseDeletionPage() {
        return "admin/CourseDeletion";}

    @GetMapping("/course-addition")
    public String showCourseAdditionPage() {
        return "admin/CourseAddition";}

    @GetMapping("/block-edition")
    public String showBlockEditionPage() {
        return "admin/BlockEdition";}

    @GetMapping("/block-deletion")
    public String showBlockDeletionPage() {
        return "admin/BlockDeletion";}

    @GetMapping("/block-addition")
    public String showBlockAdditionPage() {
        return "admin/BlockAddition";}

    }






