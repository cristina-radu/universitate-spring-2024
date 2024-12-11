package com.example.lab4.repository;

import com.example.lab4.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    @PostConstruct
    private void setUp() {
        students.add(new Student("Maria", "Popscu", 20));
        students.add(new Student("Ion", "Dragu", 21));
        students.add(new Student("Mircea", "Stroie", 21));
    }

    public List<Student> getStudents() {
        return students;
    }
}
