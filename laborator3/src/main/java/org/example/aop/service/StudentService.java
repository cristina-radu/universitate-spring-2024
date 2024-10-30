package org.example.aop.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StudentService {

    public void getAllStudents() {
        System.out.println("Retrieving all students.");
    }

    public void getStudentById(){
        throw new RuntimeException("No student with id in db.");
    }
}
