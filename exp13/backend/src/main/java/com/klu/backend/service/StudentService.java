package com.klu.backend.service;

import java.util.List;
import com.klu.backend.model.Student;

public interface StudentService {

Student addStudent(Student s);

List<Student> getStudents();

Student updateStudent(int id,Student s);

void deleteStudent(int id);

}