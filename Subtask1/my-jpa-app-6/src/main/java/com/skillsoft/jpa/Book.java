package com.skillsoft.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name ="author_name", columnDefinition = "VARCHAR(55)",nullable = false)
	private String author;
	
	@Column(name="book_title",nullable = false,unique = true,length = 55)
	private String title;
	
	@Column(precision = 7,scale = 4)
	private Float price;
	
	@Transient
	private boolean inStock;
	
	public Book() {
	}
	
	public Book(String author, String title, Float price) {
		super();
		this.author = author;
		this.title = title;
		this.price = price;
		
		this.inStock = true;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	
}
