package com.example.coursemanager.controller;

import com.example.coursemanager.dto.UserDto;
import com.example.coursemanager.model.User;
import com.example.coursemanager.repository.RoleJpaRepository;
import com.example.coursemanager.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequestMapping("/user")
@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleJpaRepository roleJpaRepository;

    @GetMapping("/add")
    public String showUserAdditionPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("roleList", roleJpaRepository.findAll());
        return "admin/UserAddition";
    }

//    @PostMapping("/add")
//    public ResponseEntity<UserDto> addUser(@ModelAttribute UserDto userDto){
//        try {
//            UserDto addUser = userService.addUser(userDto);
//            return ResponseEntity.ok(addUser);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute UserDto userDto) {

        userService.addUser(userDto);
        return "/Home";

    }


    @GetMapping("/edit")
    public String showUserEditionPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("roleList", roleJpaRepository.findAll());
        return "admin/UserEdition";
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
        try {
            User updateUser = userService.updateUser(userDto, id);
            return ResponseEntity.ok(updateUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
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
        return "admin/ReportOfUsers";
    }
    @GetMapping("/report-of-courses")
    public String showReportOfCoursesPage() {
        return "admin/ReportOfCourses";
    }
    @GetMapping("/report-of-blocks")
    public String showReportOfBlocksPage() {
        return "admin/ReportOfBlocks";
    }

    @GetMapping("/list-of-lessons")
    public String showReportOfLessonsPage() {
        return "admin/ReportOfLessons";
    }

    @GetMapping("/course-edition")
    public String showCourseEditionPage() {
        return "admin/CourseEdition";
    }

    @GetMapping("/course-deletion")
    public String showCourseDeletionPage() {
        return "admin/CourseDeletion";
    }

    @GetMapping("/course-addition")
    public String showCourseAdditionPage() {
        return "admin/CourseAddition";
    }

    @GetMapping("/block-edition")
    public String showBlockEditionPage() {
        return "admin/BlockEdition";
    }

    @GetMapping("/block-deletion")
    public String showBlockDeletionPage() {
        return "admin/BlockDeletion";
    }

    @GetMapping("/block-addition")
    public String showBlockAdditionPage() {
        return "admin/BlockAddition";
    }

}






