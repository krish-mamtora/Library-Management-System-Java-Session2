package com.example.demo.repository;

import com.example.demo.model.AuthorBook;
import com.example.demo.model.AuthorBookId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorBookRepository extends JpaRepository<AuthorBook , AuthorBookId> {
    List<AuthorBook> findByAuthorId(Long authorId);
    List<AuthorBook> findBookById(Long bookId);

}
