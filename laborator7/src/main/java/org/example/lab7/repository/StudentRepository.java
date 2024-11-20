package org.example.lab7.repository;

import org.example.lab7.exception.StudentAlreadyExistsException;
import org.example.lab7.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void saveStudent(Student student){
        if (students.stream().filter(elem -> elem.getCnp().equals(student.getCnp())).count() > 0) {
            throw new StudentAlreadyExistsException("Student with cnp " + student.getCnp() + " already exists in the application.");
        }
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
