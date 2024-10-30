package org.example.bean_singleton.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.bean_singleton.service")
public class ApplicationConfigOne {

/*    @Bean
    public StudentService studentService(){
        return new StudentService();
    }*/
}
