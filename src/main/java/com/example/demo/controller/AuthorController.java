package com.example.demo.controller;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public void addAuthor(@RequestBody AuthorDTO dto){
        authorService.addAuthor(dto);
    }

    @DeleteMapping
    public void deleteAuthor(@PathVariable @Positive Long id){
        authorService.deleteAuthor(id);
    }

}
