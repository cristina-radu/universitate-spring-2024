package org.example.laborator9.controller;

import org.example.laborator9.exception.DuplicateStudentCnpException;
import org.example.laborator9.model.Student;
import org.example.laborator9.service.StudentService;
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
    public void saveStudent(@RequestBody Student student) throws DuplicateStudentCnpException {
        studentService.saveStudent(student);
    }

    @GetMapping("/age-between/{minLimit}/{maxLimit}")
    public List<Student> getStudentsWithAgeBetween(@PathVariable Integer minLimit, @PathVariable Integer maxLimit) {
        return studentService.getStudentsWithAgeBetween(minLimit, maxLimit);
    }

    @GetMapping("/score-greater/{score}")
    public List<Student> getStudentsWithScoreGreaterThanEquals(@PathVariable Float score) {
        return studentService.getStudentsWithScoreGreaterThanEquals(score);
    }

    @GetMapping("/avg-score")
    public Float getAvgScore() {
        return studentService.getAvgScore();
    }

    @GetMapping("/avg-score-native")
    public Float getAvgScoreNave() {
        return studentService.getAvgScoreNative();
    }
}
