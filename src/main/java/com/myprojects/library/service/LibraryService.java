package com.myprojects.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myprojects.library.model.Library;
import com.myprojects.library.model.Member;
import com.myprojects.library.repository.LibraryRepository;
import com.myprojects.library.repository.MemberRepository;
@Service
public class LibraryService {
    private LibraryRepository libraryRepository;
    private MemberRepository memberRepository;

    public LibraryService(LibraryRepository libraryRepository,MemberRepository memberRepository) {
        this.libraryRepository = libraryRepository;
        this.memberRepository = memberRepository;
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public void addLibrary(Library library) {
        libraryRepository.insert(library);
    }
    public Library UpdateLibrary(String libraryId) {
        Library library = libraryRepository.findById(libraryId).orElse(null);
        return libraryRepository.save(library);
    }

    public Library addMemberToLibrary(String libraryId, String memberId) {
        Library library = libraryRepository.findById(libraryId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);

        if (library != null && member != null) {
            List<String> membersIds = library.getMemberIds();
            membersIds.add(memberId);
            return libraryRepository.save(library);
        }

        return null; // Handle error case
    }

    public Library DeleteLibrary(String libraryId){
        Library library = libraryRepository.findById(libraryId).orElse(null);
        if(library != null){
            libraryRepository.delete(library);
        }
        return null;
    }
    
    
}
