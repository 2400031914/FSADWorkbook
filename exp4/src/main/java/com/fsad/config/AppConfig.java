package com.fsad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fsad.model.Student;

@Configuration
public class AppConfig {

    @Bean
    public Student student() {

        Student s = new Student(101, "Indrani");
        s.setCourse("CSE");
        s.setYear(2);

        return s;
    }
}