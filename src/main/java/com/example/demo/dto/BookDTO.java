package com.example.demo.dto;

import java.util.Set;

public class BookDTO {
    private String title;
    private String isbn;
    private int publishYear;
    private Set<Long> authorIds;
    private Long libraryId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public Set<Long> getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(Set<Long> authorIds) {
        this.authorIds = authorIds;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId( Long libraryId) {
        this.libraryId = libraryId;
    }
}
