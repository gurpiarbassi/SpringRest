package com.gurps.library.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gurps.library.domain.Book;
import com.gurps.library.domain.BookSpecification;

@Service
public interface LibraryService {

	
	void saveBook(Book book);
	void deleteBook(Book book);
	void deleteBook(String id);
	Book findBook(BookSpecification bookSpec);
	List<Book> findBooks();
	
	List<Book>findByAgeGreaterThan(int age);
	
	List<Book>findByAgeIn(Collection ages);
	
}
