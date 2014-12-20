package com.gurps.library.rest.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gurps.library.domain.Author;
import com.gurps.library.domain.Book;
import com.gurps.library.rest.model.RecategorisationRequest;
import com.gurps.library.rest.model.LibraryBook;
import com.gurps.library.service.LibraryService;

@RestController
@RequestMapping("/service/library")
public class LibraryController {

	
	@Autowired
	private LibraryService libraryService;
	@Autowired
	private Mapper dozerBeanMapper;
	

	@RequestMapping(value="/addBook", method = RequestMethod.POST)
	public ResponseEntity<String> addBook(@RequestBody @Valid final LibraryBook saveBookRequest){
		Book book = dozerBeanMapper.map(saveBookRequest, Book.class);
		/*Collection<Author> authors = new ArrayList<>();
		for(String authorName : saveBookRequest.getAuthors()){
			Author auth = new Author();
			auth.setName(authorName);
			authors.add(auth);
		}
		book.setAuthors(authors);
		*/
		libraryService.saveBook(book);
		//TODO perhaps test for exception here and translate to error response code??
		
		return new ResponseEntity<String>(HttpStatus.OK);	
	}
	
	@RequestMapping(value="/addBooks", method = RequestMethod.POST)
	public ResponseEntity<List<LibraryBook>> addBook(@RequestBody @Valid final List<LibraryBook> books){
		return new ResponseEntity<List<LibraryBook>>(books, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/getBook{isbn}", method = RequestMethod.GET)
	public ResponseEntity<LibraryBook> getBook(@PathVariable("isbn") @NotEmpty String isbn){
		return new ResponseEntity<LibraryBook>(new LibraryBook(), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	public ResponseEntity<LibraryBook> updateBook(@RequestBody @Valid LibraryBook book){
		return new ResponseEntity<LibraryBook>(new LibraryBook(), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/reCategorise", method = RequestMethod.PUT)
	public ResponseEntity<List<LibraryBook>> reCategorise(@RequestBody @Valid RecategorisationRequest request){
		
		List<LibraryBook> books = request.getBooks();
		books.stream().forEach(book -> book.setCategory(request.getCategory()));
		return new ResponseEntity<List<LibraryBook>>(books, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ResponseEntity<List<LibraryBook>> list(){
		
		List<Book> books = libraryService.findBooks();
		List<LibraryBook> libraryBooks = new ArrayList<LibraryBook>(books.size());
		dozerBeanMapper.map(books, libraryBooks);
		
		return new ResponseEntity<List<LibraryBook>>(libraryBooks, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "delete/{isbn}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("isbn") String isbn){
	
		System.out.println("deleting isbn " + isbn);
	}
}
