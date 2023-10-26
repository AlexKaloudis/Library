package com.myprojects.library.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("{libraryId}/{memberId}")
    public Library addMemberToLibrary(@PathVariable(name = "libraryId") String libraryId,@PathVariable(name = "memberId") String memberId) {
        return libraryService.addMemberToLibrary(libraryId, memberId);
    }
    @PutMapping("{id}")
    public ResponseEntity<Library> UpdateLibrary(@PathVariable String id, @RequestBody Library library) {
        libraryService.UpdateLibrary(id);
        return ResponseEntity.ok(library);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Library> DeleteLibrary(@PathVariable String id) {
        libraryService.DeleteLibrary(id);
        return ResponseEntity.ok(null);
    }

    
}
