package com.gurps.library.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BookSpecification {

	@NotBlank
	private String title;	
	@NotBlank
	private String author;	
	@NotBlank
	private String category;
	@NotBlank
	private String isbn;	
	@NotBlank
	private String id;
}
