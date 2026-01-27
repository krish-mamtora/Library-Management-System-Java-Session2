package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return  bookService.getAllBooks();
    }
//    @GetMapping("/{id}")
//    public Book getBookById(@PathVariable Long id){
//        return bookService.getBookById(id);
//    }

    @PostMapping
    public void addBook(@RequestBody Book book){
         bookService.addBook(book);
    }
//    @PutMapping
//    public  Book updateBook(){
//
//    }
    @DeleteMapping
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

}
