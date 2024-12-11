package org.example.many_to_many_unidirectional_no_cascade.service;

import org.example.many_to_many_unidirectional_no_cascade.dto.StudentDto;
import org.example.many_to_many_unidirectional_no_cascade.mapper.StudentCourseMapper;
import org.example.many_to_many_unidirectional_no_cascade.model.Course;
import org.example.many_to_many_unidirectional_no_cascade.model.CoursesToStudentDto;
import org.example.many_to_many_unidirectional_no_cascade.model.Student;
import org.example.many_to_many_unidirectional_no_cascade.respository.CourseRepository;
import org.example.many_to_many_unidirectional_no_cascade.respository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private StudentCourseMapper studentCourseMapper;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, StudentCourseMapper studentCourseMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentCourseMapper = studentCourseMapper;
    }

    public List<StudentDto> getStudents() {
        return studentCourseMapper.fromStudentEntitiesToDtos(studentRepository.findAll());
    }

    public StudentDto saveStudents(StudentDto studentDto) {
        Student newStudent = studentCourseMapper.fromStudentDtoToEntity(studentDto);
        List<Course> courses = courseRepository.saveAll(newStudent.getCourses());
        newStudent.setCourses(courses);
        Student savedStudent = studentRepository.save(newStudent);
        return studentCourseMapper.fromStudentEntityToDto(savedStudent);
    }

    public void addCoursesToStudent(CoursesToStudentDto coursesToStudentDto) {
        Optional<Student> studentOptional = studentRepository.findById(coursesToStudentDto.getStudentId());
        List<Course> courses = courseRepository.findAllByIdIn(coursesToStudentDto.getCourseIds());
        if (!studentOptional.isPresent() || courses.size() == 0) {
            throw new RuntimeException(" student or courseIds are not present in the db.");
        }
        Student student = studentOptional.get();
        student.addCourses(courses);
        courseRepository.saveAll(courses);
    }

}
