package com.gurps.library.rest.model;

import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import org.hibernate.validator.constraints.NotBlank;

@Data
public class LibraryBook {

	@NotBlank
	private String title;	
	
	@NotNull
	@Size(min=1)
	private Collection<String> authors;	
	@NotBlank
	private String category;
	@NotBlank
	private String isbn;
}
