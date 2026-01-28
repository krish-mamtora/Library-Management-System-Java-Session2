package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks(Pageable pageable){
        return bookRepository.findAll((Sort) pageable);
    }
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }
    public void addBook(Book book){
         bookRepository.save(book);
         System.out.println("Book Added");
    }
    public  Book updateBook(Long id , Book updatedBook){
       return  bookRepository.findById(id).map(book->{
            book.setTitle(updatedBook.getTitle());
            book.setISBN(updatedBook.getISBN());
            book.setPublishYear(updatedBook.getPublishYear());
            book.setAuthor(updatedBook.getAuthor());
           return bookRepository.save(book);
        }).orElseThrow(()->new RuntimeException("Book not founs"));
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public List<Book> findYearWiseBooks(int pubYear){
        return bookRepository.findYearWiseBooks(pubYear);
    }
}
