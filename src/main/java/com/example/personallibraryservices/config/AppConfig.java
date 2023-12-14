package com.example.personallibraryservices.config;

import com.example.personallibraryservices.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner initializeDB(@Autowired BookService service) {
        return args -> service.initializeDatabase();
    }
}
