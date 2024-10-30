package org.example.lazy_instantiation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.lazy_instantiation.service")
public class ApplicationConfigFour {

/*    @Bean
    public StudentService studentService(){
        return new StudentService();
    }*/
}
