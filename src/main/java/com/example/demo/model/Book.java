package com.example.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String ISBN;
    private int publishYear;
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="library_id")
    private Library library;
    public Book(){

    }
    public Book(long id,Library library, String title, String ISBN, int publishYear , String author) {
        this.id = id;
        this.title = title;
        this.library = library;
        this.ISBN = ISBN;
        this.publishYear = publishYear;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Library getLibrary(){
        return this.library;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
}
