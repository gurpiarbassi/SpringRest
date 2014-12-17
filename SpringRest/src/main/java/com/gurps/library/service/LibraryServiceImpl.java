package com.gurps.library.service;


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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book findBook(BookSpecification bookSpec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findBooks() {
		return libraryRepository.findAll();
	}

}
