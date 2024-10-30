package org.example.eager_instantiation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.eager_instantiation.service")
public class ApplicationConfigThree {

/*    @Bean
    public StudentService studentService(){
        return new StudentService();
    }*/
}
