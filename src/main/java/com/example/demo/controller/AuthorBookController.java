package com.example.demo.controller;

import com.example.demo.dto.AuthorBookDTO;
import com.example.demo.model.AuthorBook;
import com.example.demo.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author-book")
public class AuthorBookController {
    @Autowired
    private AuthorBookService authorBookService;

    @PostMapping("/assign")
    public AuthorBook assignAuthorToBook(@RequestParam Long authorid , @RequestParam Long bookId){
        return authorBookService.assignAuthortoBook(authorid , bookId);
    }
}
