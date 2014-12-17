package com.gurps.library.domain;

import lombok.Data;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Author {
	
	@NotBlank
	@Field("name")
	private String name;
	
}
