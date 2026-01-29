package com.example.demo.service;

import com.example.demo.dto.LibraryDTO;
import com.example.demo.mapper.LibraryMapper;
import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public void createLibrary(LibraryDTO dto){
        Library library = new Library();
        library.setName((dto.getName()));
        library.setLocation(dto.getLocation());

        Library savedLibrary = libraryRepository.save(library);
    }

    public LibraryDTO getLibraryById(Long id){
        Library library = libraryRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        LibraryDTO dto = new LibraryDTO();
        dto.setId(library.getId());
        dto.setName((library.getName()));
        dto.setLocation(library.getLocation());

        return dto;
    }

    public List<LibraryDTO> getAllLibrary(){
        List<Library> libraries = libraryRepository.findAll();
        List<LibraryDTO> dtoList = new ArrayList<>();
        for(Library library : libraries){
            dtoList.add(new LibraryDTO(library.getId() , library.getName(), library.getLocation()));
        }
        return dtoList;
    }

    public void updateLibrary(Long id , LibraryDTO dto){
        Library library = libraryRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        library.setName(dto.getName());
        library.setLocation(dto.getLocation());
    }
}
