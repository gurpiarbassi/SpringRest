package com.gurps.library.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.util.Assert;

import com.gurps.library.domain.Book;
import com.mongodb.WriteResult;

public class LibraryRepositoryImpl implements LibraryRepositoryCustom {

	private final MongoOperations operations;

	@Autowired
	public LibraryRepositoryImpl(MongoOperations operations) {

		Assert.notNull(operations, "MongoOperations not supplied");
		this.operations = operations;
	}

	@Override
	public void deleteBookByIsbn(String isbn) {
		operations.remove(query(where("isbn").is(isbn)), Book.class);	
	}

}
