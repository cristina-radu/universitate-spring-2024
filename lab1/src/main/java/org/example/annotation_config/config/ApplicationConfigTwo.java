package org.example.annotation_config.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.annotation_config.service"})
public class ApplicationConfigTwo {
}
