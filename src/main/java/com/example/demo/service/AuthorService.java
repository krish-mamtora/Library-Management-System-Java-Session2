package com.example.demo.service;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.LibraryDTO;
import com.example.demo.model.Author;
import com.example.demo.model.Library;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<AuthorDTO> getAllAuthors(){
        List<Author> libraries = authorRepository.findAll();
        List<AuthorDTO> dtoList = new ArrayList<>();
        for(Author author : libraries){
            dtoList.add(new AuthorDTO(author.getId() , author.getName()));
        }
        return dtoList;
    }
    public AuthorDTO getAuthorById(long id){
       Author author = authorRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
       return new AuthorDTO(author.getId() , author.getName());
    }
    public void addAuthor(AuthorDTO dto){
       Author author = new Author();
       author.setName(dto.getName());
       Author saved = authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
//        authorRepository.deleteById(id);
    }

}
