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
        return "admin/user/UserAddition";
    }

    @GetMapping("/management")
    public String showReportOfUserPage(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("usersList", userList);
        return "admin/user/UserManagement";
    }


    @PostMapping("/add")
    public String addUser(@ModelAttribute UserDto userDto) {

        userService.addUser(userDto);
        return "redirect:/user/management";

    }


    @GetMapping("/edit")
    public String showUserEditionPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("roleList", roleJpaRepository.findAll());
        return "admin/UserEdition";
    }

    @GetMapping("/edit/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
       User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "admin/user/UserEdition";
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@ModelAttribute UserDto userDto, @PathVariable Long id) {
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


}






