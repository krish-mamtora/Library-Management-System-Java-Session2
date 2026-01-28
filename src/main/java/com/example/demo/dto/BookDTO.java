package com.example.demo.dto;

import com.example.demo.model.Book;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class BookDTO {

    private Long id;
    private String title;
    private Long libraryId;
    boolean isAvailable ;

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

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
