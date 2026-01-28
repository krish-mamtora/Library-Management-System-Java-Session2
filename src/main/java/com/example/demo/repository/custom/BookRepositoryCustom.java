package com.example.demo.repository.custom;

import com.example.demo.model.Book;

import java.util.List;

public interface BookRepositoryCustom {
    List<Book> findBooksWithAvailability(String title , Boolean available);
}
