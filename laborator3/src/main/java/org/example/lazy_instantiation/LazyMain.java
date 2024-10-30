package org.example.lazy_instantiation;

import org.example.lazy_instantiation.config.ApplicationConfigFour;
import org.example.lazy_instantiation.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfigFour.class);
        StudentService studentService = (StudentService)applicationContext.getBean("studentService");
    }
}