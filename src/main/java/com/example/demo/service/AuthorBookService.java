package com.example.demo.service;

import com.example.demo.dto.AuthorBookDTO;
import com.example.demo.model.Author;
import com.example.demo.model.AuthorBook;
import com.example.demo.model.AuthorBookId;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorBookRepository;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorBookService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorBookRepository authorBookRepository;
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public AuthorBook assignAuthortoBook(Long authorId , Long bookId){
        Author author = authorRepository.findById(authorId).orElseThrow(()-> new RuntimeException("Author not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(()-> new RuntimeException("Book not found"));
        AuthorBook authorBook = new AuthorBook(author , book);
        return authorBookRepository.save(authorBook);

    }

}
