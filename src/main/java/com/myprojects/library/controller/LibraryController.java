package com.myprojects.library.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myprojects.library.model.Library;
import com.myprojects.library.service.LibraryService;

@RestController
@RequestMapping("api/v1/libraries")
public class LibraryController {
    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<Library> GetLibraries() {
        return libraryService.getAllLibraries();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void AddLibrary(@RequestBody Library library) {
        libraryService.addLibrary(library);
    }
    // @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    // public void BorrowBook(@RequestBody Library library) {
    //     libraryService.addLibrary(library);
    // }
    
}
