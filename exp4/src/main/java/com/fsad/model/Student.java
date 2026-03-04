package com.fsad.model;

public class Student {

    private int studentId;
    private String name;
    private String course;
    private int year;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void display() {
        System.out.println(studentId + " " + name + " " + course + " " + year);
    }
}