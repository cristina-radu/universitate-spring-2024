package org.example.bean_singleton.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StudentService {
    private static int noOfInstances = 0;

    @PostConstruct
    private void setUp() {
        noOfInstances ++;
        System.out.println("Instance no: " + noOfInstances);
    }

    public void getAllStudents() {
        System.out.println("Retrieving all students.");
    }
}
