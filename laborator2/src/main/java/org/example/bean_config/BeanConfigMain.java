package org.example.bean_config;

import org.example.bean_config.bean.Car;
import org.example.bean_config.config.ApplicationConfigOne;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanConfigMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfigOne.class);

        System.out.println("Get bean by class");
        Car beanByClass = applicationContext.getBean(Car.class);
        System.out.println(beanByClass);

        System.out.println("Get bean by name");
        Car beanByName = (Car) applicationContext.getBean("volvo");
        System.out.println(beanByName);
    }
}
