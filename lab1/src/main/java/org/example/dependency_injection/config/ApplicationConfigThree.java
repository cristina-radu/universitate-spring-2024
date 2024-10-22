package org.example.dependency_injection.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.dependency_injection.service",
        "org.example.dependency_injection.repository"})
public class ApplicationConfigThree {
}
