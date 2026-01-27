package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "author_book")
public class AuthorBook {

    @EmbeddedId
    private AuthorBookId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("authorId")
    @JoinColumn(name = "author_id")
    private Author auther;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private  Book book;

    public AuthorBook(){

    }
    AuthorBook(Book book , Author author){
        this.auther = author;
        this.book= book;
        this.id = new AuthorBookId(book.getId() , author.getId());
    }

}
