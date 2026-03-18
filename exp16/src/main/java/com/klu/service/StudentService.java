package com.klu.service;

import com.klu.model.Student;
import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student updateStudent(int id, Student student);
    String deleteStudent(int id);
}