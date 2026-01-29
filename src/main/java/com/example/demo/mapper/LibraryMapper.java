package com.example.demo.mapper;

import com.example.demo.dto.LibraryDTO;
import com.example.demo.model.Library;

public class LibraryMapper {
    public static LibraryDTO toDTO(Library library){
        return new LibraryDTO(
                library.getId(),
                library.getName(),
                library.getLocation()
        );
    }
    public static Library toEntity(LibraryDTO dto){
        Library library = new Library();
        library.setId(dto.getId());
        library.setName(dto.getName());
        library.setLocation(dto.getLocation());
        return library;
    }
}
