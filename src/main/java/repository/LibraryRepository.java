package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import model.Library;

public interface LibraryRepository extends MongoRepository<Library, String>{
    
}
