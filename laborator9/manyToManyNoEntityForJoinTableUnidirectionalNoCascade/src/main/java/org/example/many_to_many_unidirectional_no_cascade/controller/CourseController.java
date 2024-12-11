package org.example.many_to_many_unidirectional_no_cascade.controller;

import org.example.many_to_many_unidirectional_no_cascade.dto.CourseDto;
import org.example.many_to_many_unidirectional_no_cascade.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseDto saveCourse(@RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto);
    }

    @GetMapping
    public List<CourseDto> getCourses(){
        return courseService.getCourses();
    }

}
