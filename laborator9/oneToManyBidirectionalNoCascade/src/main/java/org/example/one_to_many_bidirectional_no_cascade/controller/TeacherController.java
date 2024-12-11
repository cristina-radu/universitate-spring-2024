package org.example.one_to_many_bidirectional_no_cascade.controller;

import org.example.one_to_many_bidirectional_no_cascade.dto.TeacherDto;
import org.example.one_to_many_bidirectional_no_cascade.model.DepartmentsToTeacherDto;
import org.example.one_to_many_bidirectional_no_cascade.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherDto> getTeachers(){
        return teacherService.getTeachers();
    }

    @PostMapping
    public TeacherDto saveTeacher(@RequestBody TeacherDto teacher){
        return teacherService.saveTeacher(teacher);
    }

    @PutMapping("/add-disciplines-to-teacher")
    public void addDisciplinesToTeacher(@RequestBody DepartmentsToTeacherDto disciplinesToTeacherDto) {
        teacherService.addDepartmentsToTeacher(disciplinesToTeacherDto);
    }

    @PutMapping
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacher) {
        return teacherService.updateTeacher(teacher);
    }

}
