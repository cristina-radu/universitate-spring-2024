package org.example.bean_prototype.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Scope("prototype")
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
