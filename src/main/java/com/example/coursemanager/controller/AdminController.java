package com.example.coursemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @GetMapping("/user-addition")
    public String showUserAdditionPage() {
        return "admin/UserAddition";}


    @GetMapping("/user-deletion")
    public String showUserDeletionPage() {
        return "admin/UserDeletion";}


    @GetMapping("/user-edition")
    public String showUserEditionPage() {
        return "admin/UserEdition";}

    @GetMapping("/report-of-users")
    public String showReportOfUserPage() {
        return "admin/ReportOfUsers";}

    @GetMapping("/report-of-courses")
    public String showReportOfCoursesPage() {
        return "admin/ReportOfCourses";}

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






