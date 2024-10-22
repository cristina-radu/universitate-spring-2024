package org.example.annotation_config;

import org.example.annotation_config.config.ApplicationConfigTwo;
import org.example.annotation_config.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfigTwo.class);

        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.getAllStudents()
                .forEach(System.out::println);
    }
}
