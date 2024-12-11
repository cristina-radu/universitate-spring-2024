package org.example.many_to_many_unidirectional_no_cascade.controller;


import org.example.many_to_many_unidirectional_no_cascade.dto.StudentCourseDto;
import org.example.many_to_many_unidirectional_no_cascade.dto.StudentCourseRequest;
import org.example.many_to_many_unidirectional_no_cascade.service.StudentCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-course")
public class StudentCourseController {
    private StudentCourseService studentCourseService;

    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @GetMapping
    public List<StudentCourseDto> getStudentCourses(){
        return studentCourseService.getStudentCourse();
    }

    @PostMapping
    public StudentCourseDto saveStudentCourse(@RequestBody StudentCourseDto studentCourseDto){
        return studentCourseService.saveStudentCourse(studentCourseDto);
    }

    @PostMapping("/by-ids")
    public StudentCourseDto saveStudentCourseByIds(@RequestBody StudentCourseRequest studentCourseRequest){
        return studentCourseService.saveStudentCourseByIds(studentCourseRequest);
    }

}
