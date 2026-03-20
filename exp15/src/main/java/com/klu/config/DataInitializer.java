package com.klu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.klu.model.User;
import com.klu.repo.UserRepo;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if (userRepo.findByUsername("admin").isEmpty()) {
            userRepo.save(new User("admin", passwordEncoder.encode("admin123"), "ADMIN"));
        }

        if (userRepo.findByUsername("emp").isEmpty()) {
            userRepo.save(new User("emp", passwordEncoder.encode("emp123"), "EMPLOYEE"));
        }
    }
}