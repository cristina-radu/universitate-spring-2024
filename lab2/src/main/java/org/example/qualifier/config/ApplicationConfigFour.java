package org.example.qualifier.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.qualifier.service"})
public class ApplicationConfigFour {
}
