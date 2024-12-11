package org.example.dependency_injection;

import org.example.dependency_injection.config.ApplicationConfigThree;
import org.example.dependency_injection.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfigThree.class);

        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.getAllStudents().forEach(System.out::println);
    }
}
