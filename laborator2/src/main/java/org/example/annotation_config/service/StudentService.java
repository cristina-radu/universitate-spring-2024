package org.example.annotation_config.service;

import org.example.annotation_config.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Maria", "Popa"));
        students.add(new Student("George", "Marin"));
        return students;
    }
}
