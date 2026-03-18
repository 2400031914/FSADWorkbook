package com.klu.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Schema(description = "Student Entity")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Schema(description = "Unique ID of student", example = "1")
    private int id;

    @NotBlank(message = "Name cannot be empty")
    @Schema(description = "Student name", example = "Indrani")
    private String name;

    @Email(message = "Invalid email format")
    @Schema(description = "Student email", example = "indrani@gmail.com")
    private String email;

    @Schema(description = "Course name", example = "CSE")
    private String course;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}