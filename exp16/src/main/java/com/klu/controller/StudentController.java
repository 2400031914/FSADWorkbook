package com.klu.controller;

import com.klu.model.Student;
import com.klu.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @Operation(summary = "Add a new student", description = "Creates a student record in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return service.saveStudent(student);
    }

    @Operation(summary = "Get all students", description = "Fetch all student records")
    @ApiResponse(responseCode = "200", description = "List of students retrieved")
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @Operation(summary = "Get student by ID", description = "Fetch a student using ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student found"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @Operation(summary = "Update student", description = "Update student details by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student updated"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @Valid @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @Operation(summary = "Delete student", description = "Delete student by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student deleted"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}