package com.example.demo.dto;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Library;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

public class BookDTO {

    private Long id;
    private String title;
    private String ISBN;
    private int publishYear;
    private Boolean available;
    private Long libraryId;
    private Set<Long> authorIds = new HashSet<>();

    public BookDTO(){

    }
    public BookDTO(Long id, String title, String ISBN, int publishYear, Boolean available, Long libraryId, Set<Long> authorIds) {
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.publishYear = publishYear;
        this.available = available;
        this.libraryId = libraryId;
        this.authorIds = authorIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Long getLibraryID() {
        return libraryId;
    }

    public void setLibrary(Long libraryId) {
        this.libraryId = libraryId;
    }

    public Set<Long> getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(Set<Long> authorIds) {
        this.authorIds = authorIds;
    }
}
