package com.example.demo.service;

import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public void createLibrary(Library library){
        libraryRepository.save(library);
    }


}
