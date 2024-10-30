package org.example.bean_singleton;

import org.example.bean_singleton.config.ApplicationConfigOne;
import org.example.bean_singleton.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanSingletonMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfigOne.class);
        StudentService studentServiceOne = applicationContext.getBean(StudentService.class);
        StudentService studentServiceTwo = applicationContext.getBean(StudentService.class);
    }
}