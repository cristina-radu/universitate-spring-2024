package org.example.laborator8.controller;

import org.example.laborator8.model.Student;
import org.example.laborator8.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @PostMapping("save-with-procedure")
    public void saveStudentWithProcedure(@RequestBody Student student) {
        studentService.saveStudentWithProcedure(student);
    }
}
