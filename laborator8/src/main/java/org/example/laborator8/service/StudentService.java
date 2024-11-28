package org.example.laborator8.service;

import org.example.laborator8.model.Student;
import org.example.laborator8.respository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.getStudents();
    }

    public void saveStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    public void saveStudentWithProcedure(Student student) {
        studentRepository.executeProcedure(student);
    }
}
