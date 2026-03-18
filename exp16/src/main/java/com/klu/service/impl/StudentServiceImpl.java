package com.klu.service.impl;

import com.klu.model.Student;
import com.klu.repo.StudentRepo;
import com.klu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo repo;

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student updateStudent(int id, Student student) {
        Student existing = getStudentById(id);
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());
        return repo.save(existing);
    }

    public String deleteStudent(int id) {
        repo.deleteById(id);
        return "Student deleted successfully";
    }
}