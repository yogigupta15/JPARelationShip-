package com.skillsoft.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="author_name", columnDefinition = "VARCHAR(55)",nullable = false)
	private String author;
	
	@Column(name="book_title",nullable = false,unique = true,length = 55)
	private String title;
	
	@Column(precision = 7,scale = 4)
	private Float price;
	
	public Book() {
	}
	public Book(String author, String title, Float price) {
		super();
		this.author = author;
		this.title = title;
		this.price = price;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id= id;
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
	
	@Override
	public String toString() {
		return "\n{" + id + "," + title + "," + author + "," + price + "}\n";
	}

}
