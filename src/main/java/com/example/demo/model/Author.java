package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name="Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "Author", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Book> boks = new ArrayList<>();

    public Author(){

    }
    public Author(long id , String name, List<Book> boks) {
        this.id = id;
        this.name = name;
        this.boks = boks;
    }
    public long getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBoks() {
        return boks;
    }

    public void setBoks(List<Book> boks) {
        this.boks = boks;
    }
}
