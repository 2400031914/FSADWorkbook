package com.fsad.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fsad.config.Appconfig;
import com.fsad.model.Student;

public class Mainapp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(Appconfig.class);

        Student s = context.getBean(Student.class);

        s.display();
    }
}