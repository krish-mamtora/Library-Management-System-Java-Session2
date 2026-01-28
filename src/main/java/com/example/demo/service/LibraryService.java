package com.example.demo.service;

import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public void createLibrary(Library library){
        libraryRepository.save(library);
    }

    public Optional<Library> getLibrary(Long id){
        return libraryRepository.findById((id));
    }

    public List<Library> getAllLibrary(){
        return libraryRepository.findAll();
    }

    public Library updateLibrary(Long id , Library updatedLibrary){

    }
}
