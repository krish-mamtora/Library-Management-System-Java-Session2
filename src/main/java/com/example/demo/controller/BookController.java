package com.example.demo.controller;
import com.example.demo.dto.BookDTO;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping
    public List<BookDTO> getBooks(){
        return bookService.getAllBooks();
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable @Positive Long id){
        bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable  @Positive  Long id){
        return bookService.getBookById(id);
    }

    @PostMapping
    public void addBook(@RequestBody BookDTO dto){
         bookService.createBook(dto);
    }
    @GetMapping("/available/{title}/{available}")
    public List<Book> getAvailableBooks(@PathVariable String title ,@PathVariable Boolean  available){
        return bookService.findBooksWithAvailability(title , available);
    }
    @GetMapping("/year/{year}")
    public List<Book> findYearWiseBooks(@PathVariable int year){
        return bookService.findYearWiseBooks(year);
    }
}
