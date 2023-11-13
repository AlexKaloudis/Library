package com.myprojects.library.service;

import java.util.HashSet;
import java.util.List;

import com.myprojects.library.MongoConfig;
import com.myprojects.library.model.Book;
import com.myprojects.library.repository.BookRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.myprojects.library.model.Library;
import com.myprojects.library.model.Member;
import com.myprojects.library.repository.LibraryRepository;
import com.myprojects.library.repository.MemberRepository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class LibraryService {
    private LibraryRepository libraryRepository;
    private MemberRepository memberRepository;
    private BookRepository bookRepository;
    private MongoTemplate mt;


    public LibraryService(LibraryRepository libraryRepository,MemberRepository memberRepository,BookRepository bookRepository) {
        this.libraryRepository = libraryRepository;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public List<Library> GetAllLibraries() {
        return libraryRepository.findAll();
    }

    public void AddLibrary(Library library) {
        libraryRepository.insert(library);
    }
    public Library UpdateLibrary(Library updatedLibrary) {
        MongoConfig mongoConfig = new MongoConfig();
        if(updatedLibrary.getBooks() != null){
            for (Book book : updatedLibrary.getBooks()) {
                try {
                    mongoConfig.mongoTemplate().update(Library.class)
                            .matching(where("id").is(updatedLibrary.getId()))
                            .apply(new Update().push("books", book))
                            .first();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if(updatedLibrary.getMembers() != null){
            for (Member member : updatedLibrary.getMembers()) {
                mt.update(Library.class)
                        .matching(where("id").is(updatedLibrary.getId()))
                        .apply(new Update().push("members", member))
                        .first();
            }
        }

        return libraryRepository.save(updatedLibrary);
    }

//    public Library AddMemberToLibrary(String libraryId, String memberId) {
//        Library library = libraryRepository.findById(libraryId).orElse(null);
//        Member member = memberRepository.findById(memberId).orElse(null);
//        HashSet<String> membersIds = new HashSet<String>();
//        if (library != null && member != null) {
//            membersIds.add(memberId);
//            if(library.getMemberIds()!= null){
//                membersIds.addAll(library.getMemberIds());
//            }
//            library.setMemberIds(List.copyOf(membersIds));
//            return libraryRepository.save(library);
//        }
//
//        return null; // Handle error case
//    }

//    public Library AddBooksToLibrary(String libraryId,List<String> bookIds) {
//        Library library = libraryRepository.findById(libraryId).orElse(null);
//        HashSet<String> bookIdsFromDb = new HashSet<String>();
//        if(library.getBookIds() != null){
//            bookIdsFromDb.addAll(library.getBookIds());
//        }
//        if (bookIds.size()>0) {
//            bookIdsFromDb.addAll(bookIds);
//            library.setBookIds(List.copyOf(bookIdsFromDb));
//            return libraryRepository.save(library);
//        }
//        return null; // Handle error case
//    }

    public Library DeleteLibrary(String libraryId){
        Library library = libraryRepository.findById(libraryId).orElse(null);
        if(library != null){
            libraryRepository.delete(library);
        }
        return null;
    }


    public Library GetLibrary(String id) {
        Library lib = libraryRepository.findById(id).orElse(null);
        return lib;
    }
}
