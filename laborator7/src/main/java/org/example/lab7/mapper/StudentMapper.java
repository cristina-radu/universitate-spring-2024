package org.example.lab7.mapper;

import org.example.lab7.model.Student;
import org.example.lab7.request.StudentRequest;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student mapStudentRequest(StudentRequest studentRequest){
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setAge(studentRequest.getAge());
        student.setScore(studentRequest.getScore());
        student.setCnp(studentRequest.getCnp());
        return student;
    }
}
