package org.example.many_to_many_unidirectional_no_cascade.service;

import org.example.many_to_many_unidirectional_no_cascade.dto.StudentDto;
import org.example.many_to_many_unidirectional_no_cascade.mapper.StudentMapper;
import org.example.many_to_many_unidirectional_no_cascade.model.Student;
import org.example.many_to_many_unidirectional_no_cascade.respository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository,  StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDto> getStudents() {
        return studentMapper.fromEntitiesToDtos(studentRepository.findAll());
    }

    public StudentDto saveStudents(StudentDto studentDto) {
        Student newStudent = studentMapper.fromDtoToEntity(studentDto);
        Student savedStudent = studentRepository.save(newStudent);
        return studentMapper.fromEntityToDto(savedStudent);
    }

}
