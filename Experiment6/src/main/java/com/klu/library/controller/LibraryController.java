package com.klu.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.library.model.Book;
import com.klu.library.service.BookService;

@RestController
public class LibraryController {

    @Autowired
    BookService service;
    // Root URL
    @GetMapping("/")
    public String home() {
        return "Welcome to Online Library System";
    }

    // Welcome endpoint
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    // Count endpoint
    @GetMapping("/count")
    public int count() {
        return 100;
    }

    // Price endpoint
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    // Static book titles
    @GetMapping("/books")
    public List<String> books() {

        List<String> titles = new ArrayList<>();

        titles.add("Java Programming");
        titles.add("Spring Boot Guide");
        titles.add("Data Structures");

        return titles;
    }

    // Book details by ID
    @GetMapping("/books/{id}")
    public String bookDetails(@PathVariable int id) {
        return "Details of Book ID : " + id;
    }

    // Search by title
    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching for book : " + title;
    }

    // Author endpoint
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by author : " + name;
    }

    // Add book
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        service.addBook(book);
        return "Welcome to Online Library System\nBook added sucessfully";
    }

    // View all books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return service.getAllBooks();
    }
}