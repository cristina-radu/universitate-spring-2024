package org.example.eager_instantiation;

import org.example.eager_instantiation.config.ApplicationConfigThree;
import org.example.eager_instantiation.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EagerMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfigThree.class);
    }
}