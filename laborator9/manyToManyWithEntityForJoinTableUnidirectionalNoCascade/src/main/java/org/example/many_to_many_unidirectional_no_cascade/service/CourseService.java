package org.example.many_to_many_unidirectional_no_cascade.service;

import org.example.many_to_many_unidirectional_no_cascade.dto.CourseDto;
import org.example.many_to_many_unidirectional_no_cascade.mapper.CourseMapper;
import org.example.many_to_many_unidirectional_no_cascade.respository.CourseRepository;
import org.example.many_to_many_unidirectional_no_cascade.respository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;
    private CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public CourseDto saveCourse(CourseDto discipline){
        return courseMapper.fromEntityToDto(
                courseRepository.save(courseMapper.fromDtoToEntity(discipline)));
    }

    public List<CourseDto> getCourses(){
        return courseMapper.fromEntitiesToDtos(courseRepository.findAll());
    }

}
