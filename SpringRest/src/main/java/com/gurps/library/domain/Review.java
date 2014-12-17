package com.gurps.library.domain;

import lombok.Data;

@Data
public class Review {

	private String name;
	private String comment;
	private int starRating;
}
