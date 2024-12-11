package org.example.many_to_many_unidirectional_no_cascade.mapper;

import org.example.many_to_many_unidirectional_no_cascade.dto.StudentDto;
import org.example.many_to_many_unidirectional_no_cascade.model.Student;
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

    public List<Student> fromTeacherDtosToEnities(List<StudentDto> studentDtos){
        return studentDtos.stream()
                .map(elem -> fromStudentDtoToEntity(elem))
                .collect(Collectors.toList());
    }

    public Student fromStudentDtoToEntity(StudentDto studentDto){
        Student student = studentMapper.fromDtoToEntity(studentDto);
        if(studentDto.getCourses() != null) {
            student.setCourses(courseMapper.fromDtosToEnities(studentDto.getCourses()));
        }
        return student;
    }

    public List<StudentDto> fromStudentEntitiesToDtos(List<Student> students){
        return students.stream()
                .map(elem -> fromStudentEntityToDto(elem))
                .collect(Collectors.toList());
    }

    public StudentDto fromStudentEntityToDto(Student student){
        StudentDto teacherdto = studentMapper.fromEntityToDto(student);
        if(student.getCourses() != null) {
            teacherdto.setCourses(courseMapper.fromEntitiesToDtos(student.getCourses()));
        }
        return teacherdto;
    }

}
