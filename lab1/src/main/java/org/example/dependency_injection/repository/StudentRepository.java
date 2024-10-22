package org.example.dependency_injection.repository;

import org.example.dependency_injection.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Maria", "Popa"));
        students.add(new Student("George", "Marin"));
        return students;
    }
}
