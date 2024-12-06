package org.example.laborator9.service;

import org.example.laborator9.model.Student;
import org.example.laborator9.respository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

}
