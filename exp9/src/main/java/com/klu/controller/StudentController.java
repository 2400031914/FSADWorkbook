package com.klu.controller;

import org.springframework.web.bind.annotation.*;

import com.klu.exception.InvalidInputException;
import com.klu.exception.StudentNotFoundException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public String getStudent(@PathVariable int id) {

        if (id <= 0) {
            throw new InvalidInputException("Student ID must be positive");
        }

        if (id != 1) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }

        return "Student Found : ID = " + id + " Name = Indrani";
    }
}