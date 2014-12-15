package com.gurps.library.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class RecategorisationRequest {

	@Valid
	@NotNull
	@Size(min = 1)
	private List<Book> books;
	
	@NotBlank
	private String category;
	
	public RecategorisationRequest(){
		
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}	
}
