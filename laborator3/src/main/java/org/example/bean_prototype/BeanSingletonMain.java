package org.example.bean_prototype;

import org.example.bean_prototype.config.ApplicationConfigTwo;
import org.example.bean_prototype.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanSingletonMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfigTwo.class);
        StudentService studentServiceOne = applicationContext.getBean(StudentService.class);
        StudentService studentServiceTwo = applicationContext.getBean(StudentService.class);
    }
}