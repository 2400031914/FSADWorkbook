package com.klu.controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/admin")
public class AdminController{
@GetMapping("/add")
public String add(){return "Admin add";}
@GetMapping("/delete")
public String delete(){return "Admin delete";}
}