package com.gurps.library.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Book")
public class Book {

	@Id
	private String id;
	
	@NotBlank
	private String title;	
	@NotBlank
	private String author;	
	@NotBlank
	private String category;
	@NotBlank
	private String isbn;
	
	
	public Book(String title, String author, String category, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.isbn = isbn;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author
				+ ", category=" + category + ", isbn=" + isbn + "]";
	}
	
	
}
