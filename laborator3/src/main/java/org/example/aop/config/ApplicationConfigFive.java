package org.example.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = {"org.example.aop.service", "org.example.aop.aspect"})
public class ApplicationConfigFive {

/*    @Bean
    public StudentService studentService(){
        return new StudentService();
    }*/
}
