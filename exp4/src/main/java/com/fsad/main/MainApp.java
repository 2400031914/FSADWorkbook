package com.fsad.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.fsad.config.AppConfig;
import com.fsad.model.Student;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Student s = context.getBean(Student.class);

        s.display();
    }
}