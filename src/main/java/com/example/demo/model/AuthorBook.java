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
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private  Book book;

    public AuthorBook(){

    }
    public AuthorBook( Author author , Book book){
        this.author = author;
        this.book= book;
        this.id = new AuthorBookId( author.getId() , book.getId());
    }

    public AuthorBookId getId() {
        return id;
    }

    public void setId(AuthorBookId id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
