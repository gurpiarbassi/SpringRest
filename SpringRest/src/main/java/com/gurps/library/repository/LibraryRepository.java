package com.gurps.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gurps.library.domain.Book;

@Repository
public interface LibraryRepository extends MongoRepository<Book, String> {
	
}
