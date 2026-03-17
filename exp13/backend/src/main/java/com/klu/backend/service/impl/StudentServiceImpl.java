package com.klu.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.backend.model.Student;
import com.klu.backend.repo.StudentRepository;
import com.klu.backend.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

@Autowired
StudentRepository repo;

public Student addStudent(Student s){
return repo.save(s);
}

public List<Student> getStudents(){
return repo.findAll();
}

public Student updateStudent(int id,Student s){

Student st=repo.findById(id).orElse(null);

st.setName(s.getName());
st.setEmail(s.getEmail());
st.setCourse(s.getCourse());

return repo.save(st);
}

public void deleteStudent(int id){
repo.deleteById(id);
}

}