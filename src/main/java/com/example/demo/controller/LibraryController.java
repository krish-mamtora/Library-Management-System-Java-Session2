package com.example.demo.controller;

import com.example.demo.dto.LibraryDTO;
import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @PostMapping
    public void createLinrary(@RequestBody LibraryDTO libraryDTO){
            libraryService.createLibrary(libraryDTO);
    }
    @GetMapping("/{id}")
    public LibraryDTO getLibrary(@PathVariable long id ){
        return libraryService.getLibraryById(id);
    }
    @GetMapping
    List<LibraryDTO> getALLibrary(){
        return libraryService.getAllLibrary();
    }
    @PutMapping("/{id}")
    public void updateLibrary(@PathVariable long id , @RequestBody LibraryDTO dto){
        libraryService.updateLibrary(id , dto);
    }

}
