package org.example.many_to_many_unidirectional_no_cascade.mapper;

import org.example.many_to_many_unidirectional_no_cascade.dto.CourseDto;
import org.example.many_to_many_unidirectional_no_cascade.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public List<Course> fromDtosToEnities(List<CourseDto> courseDtos){
        return courseDtos.stream()
                .map(elem -> fromDtoToEntity(elem))
                .collect(Collectors.toList());
    }

    public Course fromDtoToEntity(CourseDto courseDto){
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setName(courseDto.getName());
        return course;
    }

    public List<CourseDto> fromEntitiesToDtos(List<Course> courses){
        return courses.stream()
                .map(elem -> fromEntityToDto(elem))
                .collect(Collectors.toList());
    }

    public CourseDto fromEntityToDto(Course course){
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        return courseDto;
    }
}
