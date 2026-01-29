package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "libraries")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Book> boks = new ArrayList<>();

    public Library()
    {

    }
    public Library(long id , String name, String location, List<Book> boks) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.boks = boks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Book> getBoks() {
        return boks;
    }

    public void setBoks(List<Book> boks) {
        this.boks = boks;
    }
}
