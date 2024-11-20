package org.example.lab7.service;

import org.example.lab7.mapper.StudentMapper;
import org.example.lab7.model.Student;
import org.example.lab7.repository.StudentRepository;
import org.example.lab7.request.StudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public StudentMapper studentMapper;
    public StudentRepository studentRepository;

    public StudentService(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    public void saveStudent(StudentRequest studentRequest) {
        Student student = studentMapper.mapStudentRequest(studentRequest);
        studentRepository.saveStudent(student);
    }

    public List<Student> getStudents(){
        return studentRepository.getStudents();
    }
}
