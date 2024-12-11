package org.example.bean_config.config;

import org.example.bean_config.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfigOne {
    @Primary
    @Bean("logan")
    public Car logan() {
        return new Car("Logan", "red");
    }

    @Bean("volvo")
    public Car volvo() {
        return new Car("Volvo", "black");
    }
}
