package org.example.aop.service;

import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    public void getAllTeachers() {
        System.out.println("Retrieving all teachers.");
    }

    public void getTeacherById() {
        System.out.println("Retrieving teacher by id.");
    }

    public String getTeacherName() {
        return "John";
    }
}
