package com.gurps.library.service;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.gurps.library.domain.Book;
import com.gurps.library.domain.BookSpecification;
import com.gurps.library.repository.LibraryRepository;

@Primary
@Service
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Override
	public void saveBook(Book book) {
		libraryRepository.save(book);		
	}

	@Override
	public void deleteBook(Book book) {
		libraryRepository.delete(book);
		
	}

	@Override
	public void deleteBook(String id) {
		libraryRepository.delete(id);		
	}

	@Override
	public Book findBook(BookSpecification bookSpec) {
		return null;
	}

	@Override
	public List<Book> findBooks() {
		return libraryRepository.findAll();
	}

	@Override
	public List<Book> findByAgeGreaterThan(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByAgeIn(Collection ages) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBookByIsbn(String isbn) {
		libraryRepository.deleteBookByIsbn(isbn);	
		
	}
}
