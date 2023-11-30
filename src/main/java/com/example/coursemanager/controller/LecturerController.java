package com.example.coursemanager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequestMapping("/lecturer")
@Controller
public class LecturerController {

        @GetMapping("/courses-assigned")
        public String showRegistrationPage(Model model) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
                String username = authentication.getName();
                model.addAttribute("username", username);


                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                List<String> roles = new ArrayList<>();
                for (GrantedAuthority authority : authorities) {
                    roles.add(authority.getAuthority());
                }
                model.addAttribute("roles", roles);

            }
            return "lecturer/CoursesAssigned";


        }
}
