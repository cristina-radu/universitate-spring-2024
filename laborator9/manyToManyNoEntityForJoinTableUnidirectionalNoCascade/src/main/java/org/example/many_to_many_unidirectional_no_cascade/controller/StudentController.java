package org.example.many_to_many_unidirectional_no_cascade.controller;

import org.example.many_to_many_unidirectional_no_cascade.dto.StudentDto;
import org.example.many_to_many_unidirectional_no_cascade.model.CoursesToStudentDto;
import org.example.many_to_many_unidirectional_no_cascade.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public StudentDto saveStudents(@RequestBody StudentDto student){
        return studentService.saveStudents(student);
    }

    @PutMapping("/add-courses-to-student")
    public void addCoursesToStudent(@RequestBody CoursesToStudentDto coursesToStudentDto) {
        studentService.addCoursesToStudent(coursesToStudentDto);
    }

}
