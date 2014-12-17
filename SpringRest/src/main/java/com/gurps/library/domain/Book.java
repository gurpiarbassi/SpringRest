package com.gurps.library.domain;

import java.math.BigDecimal;
import java.util.Collection;

import javax.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection="Book")
@CompoundIndexes({
    @CompoundIndex(name = "age_idx", def = "{'tit': 1, 'pub': 1}")
})
@Data
public class Book {

	@Id
	private String id;
	
	@NotBlank
	@Field("tit")
	private String title;	
	
	@NotNull
	@Field("auth")
	private Collection<Author> authors;	
	
	@Field("revs")
	private Collection<Review> reviews;
	
	@Field("revCount")
	private int reviewCount;
	
	@Field("avgRating")
	private int averageRating;
	
	@Field("rrp")
	private BigDecimal priceToBuy;	
	
	@NotBlank
	@Field("cat")
	private String category;
	
	@NotBlank
	@Field("pub")
	private String publisher;
	
	@NotBlank
	@Field("isbn")
	@Indexed(unique=true)
	private String isbn;
		
}
