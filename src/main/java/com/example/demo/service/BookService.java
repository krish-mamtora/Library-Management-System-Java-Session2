package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Library;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.custom.BookRepositoryCustomImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.print.Pageable;
import java.util.*;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyles.title;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorBookService authorBookService;
    @Autowired
    private BookRepositoryCustomImp bookRepositoryCustomImp;
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private AuthorRepository authorRepository;


    @Transactional
    public void createBook(BookDTO dto){
        Library library = libraryRepository.findById(dto.getLibraryID()).orElseThrow(()->new RuntimeException("library not found"));
        Book book = new Book();

        book.setISBN((dto.getISBN()));
        book.setTitle(dto.getTitle());
        book.setAvailable(dto.getAvailable());
        book.setPublishYear(dto.getPublishYear());
        Library library1 = libraryRepository.findById(dto.getLibraryID()).get();
        book.setLibrary(library1);

        Set<Author> authors = new HashSet<>();
        for(Long autherId : dto.getAuthorIds()){
            Author a = authorRepository.findById(autherId).orElseThrow(()->new RuntimeException("author not found"));
            authors.add(a);
        }
        book.setAuthor(authors);
        bookRepository.save(book);
//        return book;
    }

    public List<BookDTO> getAllBooks(){
//        return bookRepository.findAll();
        List<Book> books = bookRepository.findAll();
        List<BookDTO>dtoList = new ArrayList<>();
        for(Book book : books){
            BookDTO dto = new BookDTO();
            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setPublishYear(book.getPublishYear());
            dto.setISBN(book.getISBN());
            dto.setAvailable(book.getAvailable());
            Set<Long> authorIds = new HashSet<>();
            for(Author author : book.getAuthor()){
                authorIds.add(author.getId());
            }
            dto.setAuthorIds(authorIds);
            dtoList.add(dto);
        }
        return dtoList;
    }
    public List<Book> findBooksWithAvailability(String title , Boolean available){
        return bookRepositoryCustomImp.findBooksWithAvailability(title ,  available);
    }
    public BookDTO getBookById(@PathVariable Long id){
        Book book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("book not found"));
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setAvailable(book.getAvailable());
        dto.setISBN(book.getISBN());
        Set<Long> authorIds = new HashSet<>();
        for(Author author : book.getAuthor()){
            authorIds.add(author.getId());
        }
        dto.setAuthorIds(authorIds);
        return dto;
    }
    public void addBook(Book book){
//         bookRepository.save(book);
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

    public List<Book> findYearWiseBooks(int publishYear){
        return bookRepository.findYearWiseBooks(publishYear);
    }
}
