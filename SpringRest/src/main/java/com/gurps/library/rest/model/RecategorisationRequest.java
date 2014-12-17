package com.gurps.library.rest.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class RecategorisationRequest {

	@Valid
	@NotNull
	@Size(min = 1)
	private List<LibraryBook> books;
	
	@NotBlank
	private String category;
}
