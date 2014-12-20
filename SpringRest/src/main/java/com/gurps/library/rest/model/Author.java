package com.gurps.library.rest.model;

import lombok.Data;

import org.hibernate.validator.constraints.NotBlank;

@Data
public class Author {

	@NotBlank
	private String name;
}
