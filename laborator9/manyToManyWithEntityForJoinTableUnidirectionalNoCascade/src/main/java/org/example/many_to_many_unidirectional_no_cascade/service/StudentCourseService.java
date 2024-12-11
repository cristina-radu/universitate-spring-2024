package org.example.many_to_many_unidirectional_no_cascade.service;


import org.example.many_to_many_unidirectional_no_cascade.dto.StudentCourseDto;
import org.example.many_to_many_unidirectional_no_cascade.dto.StudentCourseRequest;
import org.example.many_to_many_unidirectional_no_cascade.mapper.StudentCourseMapper;
import org.example.many_to_many_unidirectional_no_cascade.model.Course;
import org.example.many_to_many_unidirectional_no_cascade.model.Student;
import org.example.many_to_many_unidirectional_no_cascade.model.StudentCourse;
import org.example.many_to_many_unidirectional_no_cascade.respository.CourseRepository;
import org.example.many_to_many_unidirectional_no_cascade.respository.StudentCourseRepository;
import org.example.many_to_many_unidirectional_no_cascade.respository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseService {
    private StudentCourseRepository studentCourseRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private StudentCourseMapper studentCourseMapper;

    public StudentCourseService(StudentRepository studentRepository, CourseRepository courseRepository,
                                StudentCourseMapper studentCourseMapper, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentCourseMapper = studentCourseMapper;
        this.studentCourseRepository = studentCourseRepository;
    }

    public List<StudentCourseDto> getStudentCourse() {
        return studentCourseMapper.fromEntitiesToDtos(studentCourseRepository.findAll());
    }

    public StudentCourseDto saveStudentCourse(StudentCourseDto studentCourseDto) {
        StudentCourse studentCourse = studentCourseMapper.fromDtoToEntity(studentCourseDto);
        studentRepository.save(studentCourse.getStudent());
        courseRepository.save(studentCourse.getCourse());
        return studentCourseMapper.fromEntityToDto(studentCourseRepository.save(studentCourse));
    }

    public StudentCourseDto saveStudentCourseByIds(StudentCourseRequest studentCourseRequest) {
        Optional<Student> studentOptional = studentRepository.findById(studentCourseRequest.getStudentId());
        Optional<Course> courseOptional = courseRepository.findById(studentCourseRequest.getCourseId());
        if(!studentOptional.isPresent() || !courseOptional.isPresent()) {
            throw new RuntimeException("Student or Course cannot be found in db.");
        }
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setScore(studentCourseRequest.getScore());
        studentCourse.setCourse(courseOptional.get());
        studentCourse.setStudent(studentOptional.get());
        StudentCourse savedStudentCourse = studentCourseRepository.save(studentCourse);
        return studentCourseMapper.fromEntityToDto(savedStudentCourse);
    }
}
