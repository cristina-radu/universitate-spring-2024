package org.example.eager_instantiation.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StudentService {

    @PostConstruct
    private void setUp() {
        System.out.println("Instantiating object.");
    }

    public void getAllStudents() {
        System.out.println("Retrieving all students.");
    }
}
