package com.example.tasks;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DateTimeFormatter dateFormatter() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }
}
