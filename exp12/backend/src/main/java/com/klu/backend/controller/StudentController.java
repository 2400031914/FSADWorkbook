package com.klu.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.backend.model.Student;
import com.klu.backend.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

@Autowired
StudentService service;

@PostMapping
public ResponseEntity<Student> addStudent(@RequestBody Student s){
return ResponseEntity.ok(service.addStudent(s));
}

@GetMapping
public ResponseEntity<List<Student>> getStudents(){
return ResponseEntity.ok(service.getStudents());
}

@PutMapping("/{id}")
public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student s){
return ResponseEntity.ok(service.updateStudent(id,s));
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteStudent(@PathVariable int id){
service.deleteStudent(id);
return ResponseEntity.ok("Deleted");
}

}