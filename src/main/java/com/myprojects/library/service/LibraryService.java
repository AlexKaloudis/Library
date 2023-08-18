package com.myprojects.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myprojects.library.model.Library;
import com.myprojects.library.repository.LibraryRepository;
@Service
public class LibraryService {
    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public void addLibrary(Library library) {
        libraryRepository.insert(library);
    }
    
    
}
