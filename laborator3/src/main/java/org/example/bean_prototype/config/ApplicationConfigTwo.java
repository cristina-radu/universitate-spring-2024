package org.example.bean_prototype.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.bean_prototype.service")
public class ApplicationConfigTwo {

/*    @Bean
    public StudentService studentService(){
        return new StudentService();
    }*/
}
