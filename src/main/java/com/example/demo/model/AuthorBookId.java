package com.example.demo.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class AuthorBookId {


    private  Long authorId;
    private  Long bookId;

    public AuthorBookId(){

    }
    public AuthorBookId(Long bookId , Long authorId){
        this.authorId = authorId;
        this.bookId = bookId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
