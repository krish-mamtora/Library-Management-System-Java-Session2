package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import jakarta.validation.constraints.Positive;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<BookDTO> getBooks(){
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "5") int size,
//            @RequestParam(defaultValue = "id") String sortBy,
//            @RequestParam(defaultValue = "asc") String sortDir) {
//
//        Sort sort = sortDir.equalsIgnoreCase("asc") ?
//                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//        Pageable pageable = (Pageable) PageRequest.of(page, size, sort);
        return bookService.getAllBooks();
    }


    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PostMapping
    public void addBook(@RequestBody BookDTO dto){
         bookService.createBook(dto);
    }

    @DeleteMapping
    public void deleteBook(@PathVariable @Positive Long id){
        bookService.deleteBook(id);
    }

    @GetMapping("/year/{year}")
    public List<Book> findYearWiseBooks(@PathVariable int year){
        return bookService.findYearWiseBooks(year);
    }
}
