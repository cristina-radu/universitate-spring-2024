package org.example.lazy_instantiation.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Lazy
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
