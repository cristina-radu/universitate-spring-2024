package org.example.many_to_many_unidirectional_no_cascade.mapper;

import org.example.many_to_many_unidirectional_no_cascade.dto.StudentCourseDto;
import org.example.many_to_many_unidirectional_no_cascade.dto.StudentCourseRequest;
import org.example.many_to_many_unidirectional_no_cascade.dto.StudentDto;
import org.example.many_to_many_unidirectional_no_cascade.model.Course;
import org.example.many_to_many_unidirectional_no_cascade.model.Student;
import org.example.many_to_many_unidirectional_no_cascade.model.StudentCourse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentCourseMapper {
    private CourseMapper courseMapper;
    private StudentMapper studentMapper;

    public StudentCourseMapper(CourseMapper courseMapper, StudentMapper studentMapper) {
        this.courseMapper = courseMapper;
        this.studentMapper = studentMapper;
    }

    public List<StudentCourse> fromDtosToEnities(List<StudentCourseDto> studentDtos){
        return studentDtos.stream()
                .map(elem -> fromDtoToEntity(elem))
                .collect(Collectors.toList());
    }

    public StudentCourse fromDtoToEntity(StudentCourseDto studentCourseDto){
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setCourse(courseMapper.fromDtoToEntity(studentCourseDto.getCourse()));
        studentCourse.setStudent(studentMapper.fromDtoToEntity(studentCourseDto.getStudent()));
        return studentCourse;
    }

    public List<StudentCourseDto> fromEntitiesToDtos(List<StudentCourse> students){
        return students.stream()
                .map(elem -> fromEntityToDto(elem))
                .collect(Collectors.toList());
    }

    public StudentCourseDto fromEntityToDto(StudentCourse studentCourse){
        StudentCourseDto studentCourseDto = new StudentCourseDto();
        studentCourseDto.setScore(studentCourse.getScore());
        studentCourseDto.setStudent(studentMapper.fromEntityToDto(studentCourse.getStudent()));
        studentCourseDto.setCourse(courseMapper.fromEntityToDto(studentCourse.getCourse()));
        return studentCourseDto;
    }

}
