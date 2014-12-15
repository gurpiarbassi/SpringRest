package com.gurps.library.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gurps.library.repository.LibraryRepository;

@RestController
@RequestMapping("/service/library")
public class LibraryController {

	
	private LibraryRepository libraryRepository;
	
	@Autowired
	public void setLibraryRepository(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}

	@RequestMapping(value="/addBook", method = RequestMethod.POST)
	public ResponseEntity<Book> addBook(@RequestBody @Valid final Book book){
		return new ResponseEntity<Book>(book, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/addBooks", method = RequestMethod.POST)
	public ResponseEntity<List<Book>> addBook(@RequestBody @Valid final List<Book> books){
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/getBook{isbn}", method = RequestMethod.GET)
	public ResponseEntity<Book> getBook(@PathVariable("isbn") @NotEmpty String isbn){
		return new ResponseEntity<Book>(new Book(), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	public ResponseEntity<Book> updateBook(@RequestBody @Valid Book book){
		return new ResponseEntity<Book>(new Book(), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/reCategorise", method = RequestMethod.PUT)
	public ResponseEntity<List<Book>> reCategorise(@RequestBody @Valid RecategorisationRequest request){
		
		List<Book> books = request.getBooks();
		books.stream().forEach(book -> book.setCategory(request.getCategory()));
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> list(){
		
		
		//List<com.gurps.library.domain.Book> allBooks = libraryRepository.findAll();
		List<Book> books = new ArrayList<>();
		Book book1 = new Book();
		book1.setAuthor("kiki");
		book1.setTitle("my title");
		book1.setCategory("children");
		book1.setIsbn("98765");
		books.add(book1);
		
		Book book2 = new Book();
		book2.setAuthor("deep");
		book2.setTitle("grufallo");
		book2.setCategory("children");
		book2.setIsbn("12345");
		books.add(book2);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "delete/{isbn}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("isbn") String isbn){
	
		System.out.println("deleting isbn " + isbn);
	}
}
