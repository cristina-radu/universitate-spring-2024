package org.example.lab7.controller;

import jakarta.validation.Valid;
import org.example.lab7.model.Student;
import org.example.lab7.request.StudentRequest;
import org.example.lab7.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/student")
@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void saveStudent(@RequestBody @Valid StudentRequest studentRequest) {
        studentService.saveStudent(studentRequest);
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
}
