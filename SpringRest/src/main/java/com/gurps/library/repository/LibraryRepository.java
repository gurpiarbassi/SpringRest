package com.gurps.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gurps.library.domain.Book;

@Repository
public interface LibraryRepository extends MongoRepository<Book, String> {
	
	/**
	 * By adding the annotation org.springframework.data.mongodb.repository.Query repository finder methods you can specify a MongoDB JSON query string to use instead of having the query derived from the method name. For example

public interface PersonRepository extends MongoRepository<Person, String>

  @Query("{ 'firstname' : ?0 }")
  List<Person> findByThePersonsFirstname(String firstname);

}


to restrict the properties returned. do @Query(value="{ 'firstname' : ?0 }", fields="{ 'firstname' : 1, 'lastname' : 1}")
	 */
	
}
