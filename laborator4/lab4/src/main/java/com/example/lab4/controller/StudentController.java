package com.example.lab4.controller;

import com.example.lab4.model.Student;
import com.example.lab4.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/student")
@Controller
public class StudentController {
    private StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("data", studentService.getStudents());
        model.addAttribute("student", new Student());
        return "student";
    }
}
